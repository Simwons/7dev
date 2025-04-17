package kr.co.chill.quotation;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.chill.material.MaterialDTO;
import kr.co.chill.material.MaterialService;

@Controller
public class QuotationController {
	@Autowired
	private ServletContext servletContext;
	
	@Inject
	QuotationService quotationService;
	
	@Inject
	MaterialService materialService;
	
	//메인화면
	@GetMapping("quotation/quotation_main")
	public String quotationMain(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, HttpSession session
			, HttpServletRequest request
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
			, HttpSession session
			, HttpServletRequest request
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
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		MaterialDTO materialDTO = materialService.getMaterialByMaterialNo(materialNo);
		model.addAttribute("material", materialDTO);
		return "quotation/quotation_createQuotation";
	}
	
	//신규등록3 - 작성한 견적서 db에 등록
	@PostMapping("quotation/createQuotation")
	public String createQuotation(@ModelAttribute("quotation")QuotationDTO quotationDTO
			,@RequestParam("file") MultipartFile file
			,HttpServletRequest request
			,HttpSession session) throws Exception {
	    if (!file.isEmpty()) {
	        String uploadDir = servletContext.getRealPath("/resources/file/");
	        
	        String fileName = file.getOriginalFilename();
	        File dest = new File(uploadDir + fileName);
	        file.transferTo(dest);

	        quotationDTO.setQuotFile(fileName); // DB에 파일명 저장
	    }
		quotationService.createQuotation(quotationDTO);
		return "redirect:/quotation/quotation_main";
	}
	
	//견적서 상세보기
	@GetMapping("quotation/selectQuotation")
	public String selectQuotation(@RequestParam("quotNo")int quotNo
			, HttpSession session
			, HttpServletRequest request
			,Model model) throws Exception {
		QuotationDTO quotationDTO = quotationService.readQuotationByQuotNo(quotNo);
		
		String quotPterms = quotationDTO.getQuotPterms();

		if (quotPterms != null && quotPterms.contains(",")) {
		    String[] parts = quotPterms.split(",", 2);
		    model.addAttribute("paymentMethod", parts[0].trim());
		    model.addAttribute("paymentTiming", parts[1].trim());
		}
		
		System.out.println(quotationDTO);
		model.addAttribute("quotation", quotationDTO);
		return "quotation/quotation_selectQuotation";
	}
	
	//수정 페이지로 이동
	@GetMapping("quotation/getUpdateQuotation")
	public String getUpdateQuotation(@ModelAttribute("quotation")QuotationDTO quotationDTO
			, HttpSession session
			, HttpServletRequest request
			,Model model) throws Exception {
		quotationDTO = quotationService.readQuotationByQuotNo(quotationDTO.getQuotNo());
		String quotPterms = quotationDTO.getQuotPterms();  // DB에서 가져온 문자열
		if (quotPterms != null && quotPterms.contains(",")) {
		    String[] parts = quotPterms.split(",");
		    model.addAttribute("paymentMethod", parts[0].trim());
		    
		    if (parts.length > 1) {
	            String timing = parts[1].trim();

	            // "30days after acceptance" 같은 형식일 경우
	            if (timing.matches("\\d+days after acceptance")) {
	                model.addAttribute("paymentTiming", "fewDaysAfterAcceptance");
	                model.addAttribute("days", timing.replace("days after acceptance", "").trim());
	            } else {
	                model.addAttribute("paymentTiming", timing); // atSight, inAdvance 등
	                model.addAttribute("days", ""); // daysInput 비움
	            }
	        }
		}
		System.out.println(quotationDTO);
		model.addAttribute("quotation", quotationDTO);
		return "quotation/quotation_updateQuotation";
	}
	
	//수정사항 저장
	@PostMapping("quotation/updateQuotation")
	public String updateQuotation(@ModelAttribute("quotation")QuotationDTO quotationDTO
			,@RequestParam("file") MultipartFile file
			,HttpSession session
			,HttpServletRequest request) throws Exception {
		
	    if (!file.isEmpty()) {
	        String uploadDir = servletContext.getRealPath("/resources/file/");
	        
	        String fileName = file.getOriginalFilename();
	        File dest = new File(uploadDir + fileName);
	        file.transferTo(dest);

	        quotationDTO.setQuotFile(fileName); // DB에 파일명 저장
	    }
		System.out.println(quotationDTO);
		quotationService.updateQuotation(quotationDTO);
		return "redirect:/quotation/selectQuotation?quotNo="+quotationDTO.getQuotNo();
	}
	
	

}
