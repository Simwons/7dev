package kr.co.chill.quotation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class QuotationServiceImpl implements QuotationService {
	
	@Inject
	QuotationDAO quotationDAO;
	//전체조회
	@Override
	public List<QuotationDTO> readQuotation() throws Exception {
		// TODO Auto-generated method stub
		return quotationDAO.readQuotation();
	}
	//선택조회(상세보기)
	@Override
	public QuotationDTO readQuotationByQuotNo(int quotNo) throws Exception {
		// TODO Auto-generated method stub
		return quotationDAO.readQuotationByQuotNo(quotNo);
	}
	//검색조회
	@Override
	public List<QuotationDTO> searchQuotation(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return quotationDAO.searchQuotation(searchMap);
	}
	//추가(신규등록)
	@Override
	public void createQuotation(QuotationDTO quotationDTO) throws Exception {
		// TODO Auto-generated method stub
	    String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	    String baseCode = "QT" + today;

	    int countToday = quotationDAO.countQuotationToday(today);
	    String newQuotCode = baseCode + String.format("%02d", countToday + 1);

	    quotationDTO.setQuotCode(newQuotCode);
		quotationDAO.createQuotation(quotationDTO);
	}
	//수정
	@Override
	public void updateQuotation(QuotationDTO quotationDTO) throws Exception {
		// TODO Auto-generated method stub
		quotationDAO.updateQuotation(quotationDTO);
	}
	//견적확정시
	@Override
	public void updateQuotState(int quotNo) throws Exception {
		// TODO Auto-generated method stub
		quotationDAO.updateQuotState(quotNo);
	}
	//삭제
	@Override
	public void deleteQuotation(int quotNo) throws Exception {
		// TODO Auto-generated method stub
		quotationDAO.deleteQuotation(quotNo);
	}
	
}
