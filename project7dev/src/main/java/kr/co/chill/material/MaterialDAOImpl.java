package kr.co.chill.material;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MaterialDAOImpl implements MaterialDAO {
	
	@Inject
	private SqlSession sqlSession;
	//전체조회
	@Override
	public List<MaterialDTO> readMaterial() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.materialMapper.readMaterial");
	}
	//검색조회
	@Override
	public List<MaterialDTO> searchMaterial(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.materialMapper.searchMaterial", searchMap);
	}
	//부품코드로 부품조회
	@Override
	public List<MaterialDTO> getMaterialByMaterialCode(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.materialMapper.getMaterialByMaterialCode", searchMap);
	}
	//부품 내의 제품코드로 해당부품이 어디에 쓰이는지 조회용(bom)
	@Override
	public List<MaterialDTO> getMaterialByProductNo(int productNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.materialMapper.getMaterialByProductNo", productNo);
	}
	//등록
	@Override
	public void createMaterial(MaterialDTO materialDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("kr.co.chill.materialMapper.createMaterial", materialDTO);
	}
	//수정: 사용되는 제품(BOM작성 시)
	@Override
	public void updateMaterialProductRef(Map<String, Object> updateMap) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("kr.co.chill.materialMapper.updateMaterialProductRef", updateMap);
	}
	//수정: 계약서 작성 시 
	@Override
	public void updateMaterialContract(MaterialDTO materialDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("kr.co.chill.materialMapper.updateMaterialContract", materialDTO);
	}
	//전체수정
	@Override
	public void updateMaterial(MaterialDTO materialDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("kr.co.chill.materialMapper.updateMaterial", materialDTO);
	}
	//삭제
	@Override
	public void deleteMaterial(int materialNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("kr.co.chill.materialMapper.deleteMaterial", materialNo);
	}
	//부품번호로 부품조회
	@Override
	public MaterialDTO getMaterialByMaterialNo(int materialNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.materialMapper.getMaterialByMaterialNo", materialNo);
	}
	
}
