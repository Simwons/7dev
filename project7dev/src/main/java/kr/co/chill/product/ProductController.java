package kr.co.chill.product;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.chill.material.MaterialDTO;
import kr.co.chill.material.MaterialService;

@Controller
public class ProductController {
	
	@Inject
	ProductService productService;
	
	@Inject
	MaterialService materialService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	//나중에 지우자
	@GetMapping("product/viewCode")
	public String codeView() {
		return "product/viewCode";
	}
	
	//품목정보로 이동
	@GetMapping("product/product_main")
	public String productMain(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		List<ProductDTO> productList;
		
		if (searchType != null && searchValue != null && !searchValue.isEmpty()) {
			HashMap<String, Object> searchKey = new HashMap<String, Object>();
			searchKey.put("searchType", searchType);
			searchKey.put("searchValue", searchValue);
			  
			productList = productService.searchProduct(searchKey);
		} else {
			productList = productService.readProduct();
		}
		model.addAttribute("productList", productList);
		return "product/product_main";
	}
	//품목추가
	@PostMapping("product/createProduct")
	public String createProduct(@ModelAttribute("product")ProductDTO productDTO
			, HttpSession session
			, HttpServletRequest request) throws Exception {
		productService.createProduct(productDTO);
		
		return "product/product_main";
	}
	//특정 제품 bom 보기
	@GetMapping("product/product_bom")
	public String bom(@RequestParam("productNo") int productNo, Model model
			, HttpSession session
			, HttpServletRequest request) throws Exception {
		ProductDTO productDTO = productService.getProductByProductNo(productNo);
		List<MaterialDTO> materialList = materialService.getMaterialByProductNo(productNo);
		
		model.addAttribute("product", productDTO);
		model.addAttribute("materialList", materialList);
		
		return "product/product_bom";
	}


}
