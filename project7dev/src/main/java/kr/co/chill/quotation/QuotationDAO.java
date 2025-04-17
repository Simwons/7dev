package kr.co.chill.quotation;

import java.util.List;
import java.util.Map;

public interface QuotationDAO {
	//전체조회
	List<QuotationDTO> readQuotation() throws Exception;
	//선택조회(상세보기)
	QuotationDTO readQuotationByQuotNo(int quotNo) throws Exception;
	//검색조회
	List<QuotationDTO> searchQuotation(Map<String, Object> searchMap) throws Exception;
	//추가(신규등록)
	void createQuotation(QuotationDTO quotationDTO) throws Exception;
	//수정
	void updateQuotation(QuotationDTO quotationDTO) throws Exception;
	//견적확정시
	void updateQuotState(int quotNo) throws Exception;
	//삭제
	void deleteQuotation(int quotNo) throws Exception;
	//오늘견적 갯수 세기
	int countQuotationToday(String todayDate) throws Exception;
	
}
