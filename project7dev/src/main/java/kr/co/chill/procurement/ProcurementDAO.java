package kr.co.chill.procurement;

import java.util.List;
import java.util.Map;

import kr.co.chill.product.ProductDTO;

public interface ProcurementDAO {
	//전체조회
	List<ProcurementDTO> readMpp() throws Exception;
	//검색조회
	List<ProcurementDTO> searchMpp(Map<String, Object> searchMap) throws Exception;
	//선택조회
	ProcurementDTO readMppByMppNo(int mppNo) throws Exception;
	//등록
	void createMpp(ProcurementDTO procurementDTO) throws Exception;
	//수정
	void updateMpp(ProcurementDTO procurementDTO) throws Exception;
	//오늘 작성된 갯수
	int countMppToday(String todayDate) throws Exception;
	//조달계획 차수 
	int countMppVer(String mppCode) throws Exception;
	//제품번호로 가장 최신의 제품생산계획 불러오기
	int getPrplNoByProductNo(int productNo) throws Exception;
	//우리회사
	CompanyDTO getCompanyByEmpNo(int empNo) throws Exception;

}
