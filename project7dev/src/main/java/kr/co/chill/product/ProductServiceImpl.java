package kr.co.chill.product;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	ProductDAO productDAO;

	//전체조회
	@Override
	public List<ProductDTO> readProduct() throws Exception {
		// TODO Auto-generated method stub
		return productDAO.readProduct();
	}

	//검색조회
	@Override
	public List<ProductDTO> searchProduct(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.searchProduct(searchMap);
	}
	
	//품목코드로 품목조회
	@Override
	public List<ProductDTO> getProductByProductCode(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.getProductByProductCode(searchMap);
	}

	//품목번호로 bom조회
	@Override
	public ProductDTO getProductByProductNo(int productNo) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.getProductByProductNo(productNo);
	}
	
	//등록
	@Override
	public void createProduct(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
		productDAO.createProduct(productDTO);
	}

	//수정
	@Override
	public void updateProduct(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
		productDAO.updateProduct(productDTO);
	}

	//삭제
	@Override
	public void deleteProduct(int productNo) throws Exception {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(productNo);
	}

	
}
