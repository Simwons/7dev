package kr.co.chill.quotation;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.chill.material.MaterialDTO;
import kr.co.chill.material.MaterialService;

@Controller
public class QuotationController {
	
	@Inject
	QuotationService quotationService;
	
	@Inject
	MaterialService materialService;
	
	//메인화면
	@GetMapping("quotation/quotation_main")
	public String quotationMain(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, Model model) throws Exception {
		List<QuotationDTO> quotationList;
		if(searchType!=null && searchValue != null && !searchValue.isEmpty()) {
			HashMap<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("searchType", searchType);
			searchMap.put("searchValue", searchValue);
			quotationList = quotationService.searchQuotation(searchMap);
		}else {
			quotationList = quotationService.readQuotation();
		}
		model.addAttribute("quotationList", quotationList);
		return "quotation/quotation_main";
	}
	//신규등록1 - 자재선택창 가기
	@GetMapping("quotation/selectMaterial")
	public String selectMaterial(@RequestParam(value = "searchType", required = false)String searchType
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
		return "quotation/quotation_selectMaterial";
	}
	
	//신규등록2 - 선택한 제품 견적서 작성
	@GetMapping("quotation/getCreateQuotation")
	public String getCreateQuotation(@RequestParam("materialNo")int materialNo
			, Model model) throws Exception {
		MaterialDTO materialDTO = materialService.getMaterialByMaterialNo(materialNo);
		model.addAttribute("material", materialDTO);
		return "quotation/quotation_createQuotation";
	}
	
	//신규등록3 - 작성한 견적서 db에 등록
	@PostMapping("quotation/createQuotation")
	public String createQuotation(@ModelAttribute("quotation")QuotationDTO quotationDTO) throws Exception {
		quotationService.createQuotation(quotationDTO);
		return "redirect:/quotation/quotation_main";
	}
	
	//견적서 상세보기
	@GetMapping("quotation/selectQuotation")
	public String selectQuotation(@RequestParam("quotNo")int quotNo
			,Model model) throws Exception {
		QuotationDTO quotationDTO = quotationService.readQuotationByQuotNo(quotNo);
		
		String quotPterms = quotationDTO.getQuotPterms();

		if (quotPterms != null && quotPterms.contains(",")) {
		    String[] parts = quotPterms.split(",", 2);
		    model.addAttribute("paymentMethod", parts[0].trim());
		    model.addAttribute("paymentTiming", parts[1].trim());
		}

		model.addAttribute("quotation", quotationDTO);
		return "quotation/quotation_selectQuotation";
	}
	
	

}
