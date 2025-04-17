package kr.co.chill.contract;

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

import kr.co.chill.quotation.QuotationDTO;
import kr.co.chill.quotation.QuotationService;
import kr.co.chill.supplier.SupplierDTO;
import kr.co.chill.supplier.SupplierService;

@Controller
public class ContractController {
	@Autowired
	private ServletContext servletContext;
	
	@Inject
	ContractService contractService;
	
	@Inject
	QuotationService quotationService;
	
	@Inject
	SupplierService supplierService;
	
	//메인화면
	@GetMapping("contract/contract_main")
	public String contractMain(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		List<ContractDTO> contractList;
		if(searchType!=null && searchValue != null && !searchValue.isEmpty()) {
			HashMap<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("searchType", searchType);
			searchMap.put("searchValue", searchValue);
			contractList = contractService.searchContract(searchMap);
		}else {
			contractList = contractService.readContract();
		}
		System.out.println(contractList);
		model.addAttribute("contractList", contractList);
		return "contract/contract_main";
	}
	
	//신규등록1 - 견적선택창 가기
	@GetMapping("contract/selectQuotation")
	public String selectQuotation(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		List<QuotationDTO> quotationList;
		
		if(searchType != null && searchValue != null && !searchValue.isEmpty()) {
			HashMap<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("searchType", searchType);
			searchMap.put("searchValue", searchValue);
			quotationList = quotationService.searchQuotation(searchMap);
		} else {
			quotationList = quotationService.readQuotation();
		}
		
		model.addAttribute("quotationList", quotationList);
		return "contract/contract_selectQuotation";
	}
	//신규등록2 - 선택한 견적 계약서 작성
	@GetMapping("contract/getCreateContract")
	public String getCreateContract(@RequestParam("quotNo")int quotNo
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		QuotationDTO quotationDTO = quotationService.readQuotationByQuotNo(quotNo);
		SupplierDTO supplierDTO = supplierService.readSupplierBySupNo(quotationDTO.getSupNo());
		
		String quotPterms = quotationDTO.getQuotPterms();

		if (quotPterms != null && quotPterms.contains(",")) {
		    String[] parts = quotPterms.split(",", 2);
		    model.addAttribute("paymentMethod", parts[0].trim());
		    model.addAttribute("paymentTiming", parts[1].trim());
		}
		
		model.addAttribute("quotation", quotationDTO);
		model.addAttribute("supplier", supplierDTO);
		return "contract/contract_createContract";
	}
	//신규등록3 - 작성한 계약서 db에 등록
	@PostMapping("contract/createContract")
	public String createContract(@ModelAttribute("contract")ContractDTO contractDTO
			,@RequestParam("file") MultipartFile file
			,HttpSession session
			,HttpServletRequest request) throws Exception {
	    if (!file.isEmpty()) {
	        String uploadDir = servletContext.getRealPath("/resources/file/");
	        
	        String fileName = file.getOriginalFilename();
	        File dest = new File(uploadDir + fileName);
	        file.transferTo(dest);

	        contractDTO.setContFile(fileName); // DB에 파일명 저장
	    }
	    
	    quotationService.updateQuotState(contractDTO.getQuotNo());
	    
		contractService.createMprice(contractDTO);
		contractService.createContract(contractDTO);
		
		//int empNo = (int) session.getAttribute("empNo");  //로그인 정보를 토대로 입력
		//contractDTO.setEmpNo(empNo);
		return "redirect:/contract/contract_main";
	}
	
	//계약서 상세보기
	@GetMapping("contract/selectContract")
	public String selectContract(@RequestParam("contNo")int contNo
			, HttpSession session
			, HttpServletRequest request
			,Model model) throws Exception {
		ContractDTO contractDTO = contractService.readContractByContNo(contNo);
		
		String contPterms = contractDTO.getContPterms();

		if (contPterms != null && contPterms.contains(",")) {
		    String[] parts = contPterms.split(",", 2);
		    model.addAttribute("paymentMethod", parts[0].trim());
		    model.addAttribute("paymentTiming", parts[1].trim());
		}

		model.addAttribute("contract", contractDTO);
		return "contract/contract_selectContract";
	}
		
	
}
