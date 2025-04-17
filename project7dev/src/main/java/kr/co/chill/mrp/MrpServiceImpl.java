package kr.co.chill.mrp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MrpServiceImpl implements MrpService {
	
	@Inject
	MrpDAO mrpDAO;

	//전체조회
	@Override
	public List<MrpDTO> readMrp() throws Exception {
		// TODO Auto-generated method stub
		return mrpDAO.readMrp();
	}
	//선택조회(상세보기)
	@Override
	public List<MrpDTO> readMrpByMrpCode(String mrpCode) throws Exception {
		// TODO Auto-generated method stub
		return mrpDAO.readMrpByMrpCode(mrpCode);
	}
	//검색조회
	@Override
	public List<MrpDTO> searchMrp(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return mrpDAO.searchMrp(searchMap);
	}
	//등록
	@Override
	public void createMrp(MrpDTO mrpDTO) throws Exception {
		// TODO Auto-generated method stub
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	    String baseCode = "QT" + today;

	    int countToday = mrpDAO.countMrpToday(today);
	    String newMrpCode = baseCode + String.format("%02d", countToday + 1);

	    mrpDTO.setMrpCode(newMrpCode);
		mrpDAO.createMrp(mrpDTO);
	}
	//mrpcode조회용
	@Override
	public String getMrpCodeByMrpNo(int mrpNo) throws Exception {
		// TODO Auto-generated method stub
		return mrpDAO.getMrpCodeByMrpNo(mrpNo);
	}
	//선택조회(mrpNo로)
	@Override
	public MrpDTO getMrpByMrpNo(int mrpNo) throws Exception {
		// TODO Auto-generated method stub
		return mrpDAO.getMrpByMrpNo(mrpNo);
	}
	
	
}
