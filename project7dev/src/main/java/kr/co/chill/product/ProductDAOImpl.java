package kr.co.chill.product;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Inject
	private SqlSession sqlSession;

	//전체조회
	@Override
	public List<ProductDTO> readProduct() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.productMapper.searchProduct");
	}

	//검색조회
	@Override
	public List<ProductDTO> searchProduct(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.productMapper.searchProduct", searchMap);
	}
	
	//품목코드로 품목조회
	@Override
	public List<ProductDTO> getProductByProductCode(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("kr.co.chill.productMapper.getProductByProductCode", searchMap);
	}

	//품목번호로 bom조회
	@Override
	public ProductDTO getProductByProductNo(int productNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.chill.productMapper.getProductByProductNo", productNo);
	}
	
	//등록
	@Override
	public void createProduct(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("kr.co.chill.productMapper.createProduct", productDTO);
	}

	//수정
	@Override
	public void updateProduct(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("kr.co.chill.productMapper.updateProduct", productDTO);
	}

	//삭제
	@Override
	public void deleteProduct(int productNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("kr.co.chill.productMapper.deleteProduct", productNo);
	}



	
	
}
