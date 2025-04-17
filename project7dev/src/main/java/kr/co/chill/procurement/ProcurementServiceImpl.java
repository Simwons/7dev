package kr.co.chill.procurement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ProcurementServiceImpl implements ProcurementService {
	
	@Inject
	ProcurementDAO procurementDAO;
	//전체조회
	@Override
	public List<ProcurementDTO> readMpp() throws Exception {
		// TODO Auto-generated method stub
		return procurementDAO.readMpp();
	}
	//선택조회
	@Override
	public ProcurementDTO readMppByMppNo(int mppNo) throws Exception {
		// TODO Auto-generated method stub
		return procurementDAO.readMppByMppNo(mppNo);
	}
	//등록
	@Override
	public void createMpp(ProcurementDTO procurementDTO) throws Exception {
		// TODO Auto-generated method stub
		procurementDAO.createMpp(procurementDTO);
	}
	//수정
	@Override
	public void updateMpp(ProcurementDTO procurementDTO) throws Exception {
		// TODO Auto-generated method stub
		procurementDAO.updateMpp(procurementDTO);
	}
	//조달계획코드생성
	public String generateNewMppCode() throws Exception {
	    String prefix = "MP";
	    String datePart = new SimpleDateFormat("yyyyMMdd").format(new Date());
	    int sequence = procurementDAO.countMppToday(datePart)+1;

	    return prefix + datePart + String.format("%02d", sequence);
	}
	//조달계획차수
	@Override
	public int countMppVer(String mppCode) throws Exception {
		// TODO Auto-generated method stub
		int mppVer = procurementDAO.countMppVer(mppCode)+1;
		return mppVer;
	}
	//제품번호로 가장 최신의 제품생산계획 불러오기
	@Override
	public int getPrplNoByProductNo(int productNo) throws Exception {
		// TODO Auto-generated method stub
		return procurementDAO.getPrplNoByProductNo(productNo);
	}
	//우리회사
	@Override
	public CompanyDTO getCompanyByEmpNo(int empNo) throws Exception {
		// TODO Auto-generated method stub
		return procurementDAO.getCompanyByEmpNo(empNo);
	}
}
