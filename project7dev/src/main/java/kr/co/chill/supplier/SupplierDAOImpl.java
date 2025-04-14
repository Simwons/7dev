package kr.co.chill.supplier;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierDAOImpl implements SupplierDAO {
	
	@Inject
	private SqlSession sqlSession;
	//전체조회
	@Override
	public List<SupplierDTO> readSupplier() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.supplierMapper.readSupplier");
	}
	//선택조회(상세보기)
	@Override
	public SupplierDTO readSupplierBySupNo(int supNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.supplierMapper.readSupplierBySupNo", supNo);
	}
	//거래처정보 검색조회
	@Override
	public List<SupplierDTO> searchSupplier(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.supplierMapper.searchSupplier", searchMap);
	}
	//사업자번호로 거래처 가져오기
	@Override
	public List<SupplierDTO> getSupplierBySupRegNo(String supRegNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.supplierMapper.getSupplierBySupRegNo", supRegNo);
	}
	//신규등록
	@Override
	public void createSupplier(SupplierDTO supplierDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("kr.co.chill.supplierMapper.createSupplier", supplierDTO);
	}
	//수정
	@Override
	public void updateSupplier(SupplierDTO supplierDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("kr.co.chill.supplierMapper.updateSupplier", supplierDTO);
	}
	//삭제
	@Override
	public void deleteSupplier(int supNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("kr.co.chill.supplierMapper.deleteSupplier", supNo);
	}
	
}
