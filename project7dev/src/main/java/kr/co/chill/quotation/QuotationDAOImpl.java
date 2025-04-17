package kr.co.chill.quotation;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class QuotationDAOImpl implements QuotationDAO {
	
	@Inject
	private SqlSession sqlSession;
	//전체조회
	@Override
	public List<QuotationDTO> readQuotation() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.quotationMapper.readQuotation");
	}
	//선택조회(상세보기)
	@Override
	public QuotationDTO readQuotationByQuotNo(int quotNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.quotationMapper.readQuotationByQuotNo", quotNo);
	}
	//검색조회
	@Override
	public List<QuotationDTO> searchQuotation(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.quotationMapper.searchQuotation", searchMap);
	}
	//추가(신규등록)
	@Override
	public void createQuotation(QuotationDTO quotationDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("kr.co.chill.quotationMapper.createQuotation", quotationDTO);
	}
	//수정
	@Override
	public void updateQuotation(QuotationDTO quotationDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("kr.co.chill.quotationMapper.updateQuotation", quotationDTO);
	}
	//견적확정시
	@Override
	public void updateQuotState(int quotNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("kr.co.chill.quotationMapper.updateQuotState", quotNo);
	}
	//삭제
	@Override
	public void deleteQuotation(int quotNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("kr.co.chill.quotationMapper.deleteQuotation", quotNo);
	}
	//오늘 견적 갯수 세기
	@Override
	public int countQuotationToday(String todayDate) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.quotationMapper.countQuotationsToday", todayDate);
	}

}
