package kr.co.chill.mrp;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MrpDAOImpl implements MrpDAO {
	
	@Inject
	private SqlSession sqlSession;

	//전체조회
	@Override
	public List<MrpDTO> readMrp() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.mrpMapper.readMrp");
	}
	//선택조회(상세보기)
	@Override
	public List<MrpDTO> readMrpByMrpCode(String mrpCode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.mrpMapper.readMrpByMrpCode", mrpCode);
	}
	//검색조회
	@Override
	public List<MrpDTO> searchMrp(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.mrpMapper.searchMrp", searchMap);
	}
	//등록
	@Override
	public void createMrp(MrpDTO mrpDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("kr.co.chill.mrpMapper.createMrp", mrpDTO);
	}
	//오늘 작성된 갯수
	@Override
	public int countMrpToday(String todayDate) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.mrpMapper.countMrpToday", todayDate);
	}
	//mrpCode조회용
	@Override
	public String getMrpCodeByMrpNo(int mrpNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.mrpMapper.getMrpCodeByMrpNo", mrpNo);
	}
	//선택조회(mrpNo로)
	@Override
	public MrpDTO getMrpByMrpNo(int mrpNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.mrpMapper.getMrpByMrpNo", mrpNo);
	}
	
}
