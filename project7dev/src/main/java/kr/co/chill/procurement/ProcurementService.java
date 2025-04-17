package kr.co.chill.procurement;

import java.util.List;

public interface ProcurementService {
	//전체조회
	List<ProcurementDTO> readMpp() throws Exception;
	//선택조회
	ProcurementDTO readMppByMppNo(int mppNo) throws Exception;
	//등록
	void createMpp(ProcurementDTO procurementDTO) throws Exception;
	//수정
	void updateMpp(ProcurementDTO procurementDTO) throws Exception;
	//조달계획코드 생성용
	String generateNewMppCode() throws Exception;
	//조달계획 차수 
	int countMppVer(String mppCode) throws Exception;
	//제품번호로 가장 최신의 제품생산계획 불러오기
	int getPrplNoByProductNo(int productNo) throws Exception;
	//우리회사
	CompanyDTO getCompanyByEmpNo(int empNo) throws Exception;
	
}
