package kr.co.chill.mrp;

import java.util.List;
import java.util.Map;

public interface MrpDAO {
	//전체조회
	List<MrpDTO> readMrp() throws Exception;
	//선택조회(상세보기)
	List<MrpDTO> readMrpByMrpCode(String mrpCode) throws Exception;
	//검색조회
	List<MrpDTO> searchMrp(Map<String, Object> searchMap) throws Exception;
	//등록
	void createMrp(MrpDTO mrpDTO) throws Exception;
	//mrpCode생성용
	int countMrpToday(String todaydate) throws Exception;
	//mrpCode조회용
	String getMrpCodeByMrpNo(int mrpNo) throws Exception;
	//선택조회(mrpNo로)
	MrpDTO getMrpByMrpNo(int mrpNo) throws Exception;

}
