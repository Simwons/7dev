package kr.co.chill.supplier;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupplierController {
	
	@Inject
	SupplierService supplierService;
	
	//부품정보로 이동
	@GetMapping("supplier/supplier_main")
	public String supplierMain(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, Model model) throws Exception {
		List<SupplierDTO> supplierList;
		
		if(searchType != null && searchValue != null && !searchValue.isEmpty()) {
			HashMap<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("searchType", searchType);
			searchMap.put("searchValue", searchValue);
			supplierList = supplierService.searchSupplier(searchMap);
		} else {
			supplierList = supplierService.readSupplier();
		}
		model.addAttribute("supplierList", supplierList);
		
		return "supplier/supplier_main";
	}
	//거래처 신규등록
	@PostMapping("supplier/createSupplier")
	public String createSupplier(@ModelAttribute("supplier")SupplierDTO supplierDTO) throws Exception {
		
		supplierService.createSupplier(supplierDTO);
		return "redirect:/supplier/supplier_main";
	}
	//거래처 상세보기
	@GetMapping("supplier/getSupplierBySupNo")
	public String getSupplierBySupNo(@RequestParam("supNo")int supNo
			, Model model) throws Exception {
		SupplierDTO supplierDTO = supplierService.readSupplierBySupNo(supNo);
		model.addAttribute("supplierDTO", supplierDTO);
		
		return "supplier/supplier_getSupplier";
	}
	//거래처 수정으로 이동
	@GetMapping("supplier/getUpdateSupplier")
	public String getUpdateSupplier(@RequestParam("supNo")int supNo
			, Model model) throws Exception {
		SupplierDTO supplierDTO = supplierService.readSupplierBySupNo(supNo);
		model.addAttribute("supplierDTO", supplierDTO);
		return "supplier/supplier_updateSupplier";
	}
	//수정하기
	@PostMapping("supplier/updateSupplier")
	public String updateSupplier(@ModelAttribute("supplier")SupplierDTO supplierDTO) throws Exception {
		supplierService.updateSupplier(supplierDTO);
		return "redirect:/supplier/getSupplierBySupNo?supNo="+supplierDTO.getSupNo();
	}
	//삭제하기
	@PostMapping("supplier/deleteSupplier")
	public String deleteSupplier(@RequestParam("supNo")int supNo) throws Exception {
		supplierService.deleteSupplier(supNo);
		return "redirect:/supplier/supplier_main";
	}
	//사업자번호로 거래처조회
	@GetMapping("supplier/getSupplierBySupRegNo")
	@ResponseBody
	public List<SupplierDTO> getSupplierBySupRegNo(@RequestParam String supRegNo) throws Exception {
		System.out.println("담겨온값:"+supRegNo);
		List<SupplierDTO> supplierList = supplierService.getSupplierBySupRegNo(supRegNo);
		System.out.println(supplierList);
		return supplierList;
	}
	
	
	
}
