package kr.co.chill.material;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MaterialController {
	
	@Inject
	MaterialService materialService;
	
	//부품정보로 이동
	@GetMapping("material/material_main")
	public String materialMain(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, Model model) throws Exception {
		List<MaterialDTO> materialList;
		
		if(searchType != null && searchValue != null && !searchValue.isEmpty()) {
			HashMap<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("searchType", searchType);
			searchMap.put("searchValue", searchValue);
			materialList = materialService.searchMaterial(searchMap);
		} else {
			materialList = materialService.readMaterial();
		}
		model.addAttribute("materialList", materialList);
		
		return "material/material_main";
	}
	
	
	//자재검색(자재코드)
	@GetMapping("material/searchMaterial")
	public String searchMaterial(@RequestParam(value = "searchValue", required = false)String searchValue
			, Model model) throws Exception {
		List<MaterialDTO> materialList;
		
		if(searchValue != null && !searchValue.isEmpty()) {
			HashMap<String, Object> searchCode = new HashMap<String, Object>();
			searchCode.put("searchValue", searchValue);
			materialList = materialService.getMaterialByMaterialCode(searchCode);
		} else {
			materialList = materialService.readMaterial();
		}
		model.addAttribute("materialList", materialList);
		return "material/searchMaterial";
	}
	//자재추가
	@PostMapping("material/createMaterial")
	public String createMaterial(@ModelAttribute("Material")MaterialDTO materialDTO) throws Exception {
		materialService.createMaterial(materialDTO);
		
		return "redirect:/product/product_bom?productNo="+materialDTO.getProductNo();
	}
	
	
}
