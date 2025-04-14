package kr.co.chill.contract;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDAOImpl implements ContractDAO {
	
	@Inject
	private SqlSession sqlSession;
	//전체조회
	@Override
	public List<ContractDTO> readContract() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.contractMapper.readContract");
	}
	//선택조회(상세보기)
	@Override
	public ContractDTO readContractByContNo(int contNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.contractMapper.readContractByContNo",contNo);
	}
	//계약번호로 선택조회
	@Override
	public List<ContractDTO> searchContract(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.contractMapper.searchContract", searchMap);
	}
	//등록
	@Override
	public void createContract(ContractDTO contractDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("kr.co.chill.contractMapper.createContract", contractDTO);
	}
	//단가등록
	@Override
	public void createMprice(ContractDTO contractDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("kr.co.chill.contractMapper.createMprice", contractDTO);
	}
	//오늘날짜인 계약 갯수 세기
	@Override
	public int countContractToday(String todayDate) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.contractMapper.countContractsToday", todayDate);
	}
	
}
