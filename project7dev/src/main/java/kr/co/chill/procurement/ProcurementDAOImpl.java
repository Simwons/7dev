package kr.co.chill.procurement;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProcurementDAOImpl implements ProcurementDAO {
	
	@Inject
	private SqlSession sqlSession;
	//전체조회
	@Override
	public List<ProcurementDTO> readMpp() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.procurementMapper.readMpp");
	}
	//선택조회
	@Override
	public ProcurementDTO readMppByMppNo(int mppNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.procurementMapper.readMppByMppNo", mppNo);
	}
	//등록
	@Override
	public void createMpp(ProcurementDTO procurementDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("kr.co.chill.procurementMapper.createMpp", procurementDTO);
	}
	//수정
	@Override
	public void updateMpp(ProcurementDTO procurementDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("kr.co.chill.procurementMapper.updateMpp", procurementDTO);
	}
	//오늘 작성된 갯수
	@Override
	public int countMppToday(String todayDate) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.procurementMapper.countMppToday", todayDate);
	}
	//조달계획 차수
	@Override
	public int countMppVer(String mppCode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.procurementMapper.countMppVer", mppCode);
	}
	//제품번호로 가장 최신의 제품생산계획 불러오기
	@Override
	public int getPrplNoByProductNo(int productNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.procurementMapper.getPrplNoByProductNo", productNo);
	}
	//우리회사
	@Override
	public CompanyDTO getCompanyByEmpNo(int empNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.procurementMapper.getCompanyByEmpNo", empNo);
	}
	
}
