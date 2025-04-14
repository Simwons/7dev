package kr.co.chill.product;

import java.util.List;
import java.util.Map;

public interface ProductService {
	//전체조회
	List<ProductDTO> readProduct() throws Exception;
	//검색조회
	List<ProductDTO> searchProduct(Map<String, Object> searchMap) throws Exception;
	//품목코드로 품목조회
	List<ProductDTO> getProductByProductCode(Map<String, Object> searchMap) throws Exception;
	//품목번호로 bom조회
	ProductDTO getProductByProductNo(int productNo) throws Exception;
	//등록
	void createProduct(ProductDTO productDTO) throws Exception;
	//수정
	void updateProduct(ProductDTO productDTO) throws Exception;
	//삭제
	void deleteProduct(int productNo) throws Exception;
	
}
