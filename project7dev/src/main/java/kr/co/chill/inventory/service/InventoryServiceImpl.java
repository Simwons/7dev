// kr.co.chill.inventory.service.InventoryServiceImpl.java
package kr.co.chill.inventory.service;

import java.text.ParseException; // 필요 없어질 수 있으나 유지
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import kr.co.chill.inventory.dto.InventoryParamDTO;
import kr.co.chill.inventory.dto.InventoryReportDTO;
import kr.co.chill.inventory.dto.InventoryStatusDTO;
import kr.co.chill.inventory.dto.MaterialDocumentDTO;
import kr.co.chill.inventory.mapper.InventoryMapper;

@Service
public class InventoryServiceImpl implements InventoryService {

    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Inject
    private InventoryMapper inventoryMapper;

    @Override
    public List<InventoryStatusDTO> getInventoryStatus(InventoryParamDTO params) {
        // 월별 조회 로직 사용 (변경 없음)
        Map<String, Object> daoParams = prepareDateParamsForMonthlyQuery(params);
        copyFilterParamsToMap(params, daoParams);
        return inventoryMapper.selectInventoryStatus(daoParams);
    }

    // ***** 수정된 부분 시작 *****
    @Override
    public List<MaterialDocumentDTO> getMaterialDocuments(InventoryParamDTO params) {
        // 변경 전: 일별 조회 로직 사용
        /*
        Map<String, Object> daoParams = new HashMap<>();
        // ServiceImpl 내에서 날짜 파싱 및 시간 조정
        prepareDateParamsForDailyQuery(params, daoParams);
        */

        // 변경 후: 월별 조회 로직 사용
        Map<String, Object> daoParams = prepareDateParamsForMonthlyQuery(params);

        // 다른 필터 파라미터 복사는 유지
        copyFilterParamsToMap(params, daoParams);

        // Mapper 호출은 변경 없음 (MyBatis 쿼리는 월 시작/종료일로 조회 가능)
        return inventoryMapper.selectMaterialDocuments(daoParams);
    }
    // ***** 수정된 부분 끝 *****

    @Override
    public List<InventoryReportDTO> getInventoryReport(InventoryParamDTO params) {
        // 월별 조회 로직 사용 (변경 없음)
        Map<String, Object> daoParams = prepareDateParamsForMonthlyQuery(params);
        copyFilterParamsToMap(params, daoParams);
        // Report 고유 필터 추가 (변경 없음)
        if (StringUtils.hasText(params.getMaterialTypeFrom())) daoParams.put("materialTypeFrom", params.getMaterialTypeFrom());
        if (StringUtils.hasText(params.getMaterialTypeTo())) daoParams.put("materialTypeTo", params.getMaterialTypeTo());
        return inventoryMapper.selectInventoryReport(daoParams);
    }

    // 월별 조회 파라미터 처리 로직 (변경 없음)
    private Map<String, Object> prepareDateParamsForMonthlyQuery(InventoryParamDTO params) {
        Map<String, Object> dateParams = new HashMap<>();
        try {
            // queryMonthFrom은 필수값으로 처리 (null 또는 빈 문자열 체크 강화)
            if (!StringUtils.hasText(params.getQueryMonthFrom())) {
                // 기본값 설정 (예: 현재 월) 또는 예외 발생 선택
                // 여기서는 예외 발생 유지
                throw new IllegalArgumentException("조회 시작월(queryMonthFrom)은 필수입니다.");
            }

            DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
            YearMonth startYearMonth = YearMonth.parse(params.getQueryMonthFrom(), monthFormatter);

            // queryMonthTo가 없으면 시작월과 동일하게 설정
            YearMonth endYearMonth = StringUtils.hasText(params.getQueryMonthTo()) ?
                                     YearMonth.parse(params.getQueryMonthTo(), monthFormatter) : startYearMonth;

            // 시작월이 종료월보다 이후인지 체크
            if (startYearMonth.isAfter(endYearMonth)) {
                throw new IllegalArgumentException("조회 시작월은 종료월보다 이전이어야 합니다.");
            }

            // 시작일 계산: 시작월의 1일 00:00:00
            LocalDate firstDayOfStartMonth = startYearMonth.atDay(1);
            LocalDateTime startOfDay = firstDayOfStartMonth.atStartOfDay();
            Date startDate = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());

            // 종료일 계산: 종료월의 마지막일 23:59:59
            LocalDate lastDayOfEndMonth = endYearMonth.atEndOfMonth();
            LocalDateTime endOfDay = lastDayOfEndMonth.atTime(23, 59, 59);
            Date endDate = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());

            // 스냅샷 날짜 계산: 시작월의 1일 이전 날짜의 23:59:59
            LocalDate lastDayOfPreviousMonth = firstDayOfStartMonth.minusDays(1);
            LocalDateTime endOfPrevDay = lastDayOfPreviousMonth.atTime(23, 59, 59);
            Date snapshotDate = Date.from(endOfPrevDay.atZone(ZoneId.systemDefault()).toInstant());

            dateParams.put("snapshotDate", snapshotDate); // 기초 재고 계산용
            dateParams.put("startDate", startDate);       // 기간 변동 계산용 시작
            dateParams.put("endDate", endDate);         // 기간 변동 계산용 종료

            SimpleDateFormat sdfLog = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logger.info("월별 조회 날짜 파라미터 계산: snapshotDate={}, startDate={}, endDate={}",
                    sdfLog.format(snapshotDate), sdfLog.format(startDate), sdfLog.format(endDate));

        } catch (DateTimeParseException e) {
            String errorMessage = String.format("날짜 형식 오류 (queryMonthFrom: %s, queryMonthTo: %s)",
                    params.getQueryMonthFrom(), params.getQueryMonthTo());
            logger.error(errorMessage, e);
            throw new IllegalArgumentException("조회 월(YYYY-MM) 형식이 올바르지 않습니다.", e);
        } catch (IllegalArgumentException e) {
            logger.error("날짜 파라미터 오류: {}", e.getMessage());
            throw e; // Controller에서 처리하도록 다시 던짐
        } catch (Exception e) {
            logger.error("월별 조회 날짜 계산 중 오류 발생", e);
            throw new RuntimeException("날짜 계산 중 오류가 발생했습니다.", e); // 예상치 못한 오류
        }
        return dateParams;
    }

    // 변경 전: 일별 조회 날짜 처리 메소드 (이제 사용되지 않음, 주석 처리 또는 삭제 가능)
    /*
    private void prepareDateParamsForDailyQuery(InventoryParamDTO params, Map<String, Object> dateParams) {
        if (!StringUtils.hasText(params.getStartDate()) || !StringUtils.hasText(params.getEndDate())) {
             throw new IllegalArgumentException("조회 시작일(startDate)과 종료일(endDate)은 필수입니다.");
        }
        try {
            // 정규식 추가 제안 부분 포함
            String datePattern = "\\d{4}-\\d{2}-\\d{2}";
            if (!params.getStartDate().matches(datePattern) || !params.getEndDate().matches(datePattern)) {
                 logger.error("날짜 형식이 yyyy-MM-dd와 일치하지 않습니다. startDate: {}, endDate: {}", params.getStartDate(), params.getEndDate());
                 throw new IllegalArgumentException("날짜 형식(YYYY-MM-DD)이 올바르지 않습니다.");
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false); // 엄격 모드

            Date startDateParsed = sdf.parse(params.getStartDate()); // String -> Date
            Date endDateParsed = sdf.parse(params.getEndDate());   // String -> Date

            LocalDate startLocalDate = startDateParsed.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date startDateAdjusted = Date.from(startLocalDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

            LocalDate endLocalDate = endDateParsed.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDateTime endOfDay = endLocalDate.atTime(23, 59, 59);
            Date endDateAdjusted = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());

            dateParams.put("startDate", startDateAdjusted);
            dateParams.put("endDate", endDateAdjusted);

            SimpleDateFormat sdfLog = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logger.info("일별 조회 날짜 파라미터 설정: startDate={}, endDate={}",
                    sdfLog.format(startDateAdjusted), sdfLog.format(endDateAdjusted));
        } catch (ParseException e) {
             logger.error("날짜 파싱 오류 (startDate: {}, endDate: {}): {}", params.getStartDate(), params.getEndDate(), e.getMessage());
             throw new IllegalArgumentException("날짜 형식(YYYY-MM-DD)이 올바르지 않습니다.", e);
        } catch (IllegalArgumentException e) { // 형식 불일치 시
            throw e; // 이미 로깅되었으므로 다시 던짐
        } catch (Exception e) {
            logger.error("자재문서 조회 날짜 처리 중 오류 발생", e);
            throw new RuntimeException("날짜 처리 중 오류가 발생했습니다.", e);
        }
    }
    */

    // 공통 필터 파라미터 복사 로직 (변경 없음)
    private void copyFilterParamsToMap(InventoryParamDTO params, Map<String, Object> map) {
        if (StringUtils.hasText(params.getMaterialCodeFrom())) map.put("materialCodeFrom", params.getMaterialCodeFrom());
        if (StringUtils.hasText(params.getMaterialCodeTo()))   map.put("materialCodeTo", params.getMaterialCodeTo());
        if (StringUtils.hasText(params.getPlantCodeFrom()))     map.put("plantCodeFrom", params.getPlantCodeFrom());
        if (StringUtils.hasText(params.getPlantCodeTo()))       map.put("plantCodeTo", params.getPlantCodeTo());
        if (StringUtils.hasText(params.getStorageCodeFrom()))   map.put("storageCodeFrom", params.getStorageCodeFrom());
        if (StringUtils.hasText(params.getStorageCodeTo()))     map.put("storageCodeTo", params.getStorageCodeTo());
        // materialType 필터는 Report에서만 주로 사용되지만, copy 로직은 공통으로 둬도 무방
        if (StringUtils.hasText(params.getMaterialTypeFrom())) map.put("materialTypeFrom", params.getMaterialTypeFrom());
        if (StringUtils.hasText(params.getMaterialTypeTo()))   map.put("materialTypeTo", params.getMaterialTypeTo());
    }
}