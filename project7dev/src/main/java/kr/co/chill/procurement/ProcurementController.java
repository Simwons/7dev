package kr.co.chill.procurement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.chill.material.MaterialDTO;
import kr.co.chill.material.MaterialService;
import kr.co.chill.mrp.MrpDTO;
import kr.co.chill.mrp.MrpFormDTO;
import kr.co.chill.mrp.MrpService;
import kr.co.chill.purchaseorder.PurchaseorderDTO;
import kr.co.chill.purchaseorder.PurchaseorderService;
import kr.co.chill.supplier.SupplierDTO;
import kr.co.chill.supplier.SupplierService;


@Controller
public class ProcurementController {
	
	@Inject
	ProcurementService procurementService;
	
	@Inject
	MrpService mrpService;
	
	@Inject
	MaterialService materialService;
	
	@Inject
	SupplierService supplierService;
	
	@Inject
	PurchaseorderService purchaseorderService;
	
	//메인화면
	@GetMapping("mpp/mpp_main")
	public String mppMain(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		List<ProcurementDTO> mppList;
		//if(searchType!=null && searchValue != null && !searchValue.isEmpty()) {
		//	HashMap<String, Object> searchMap = new HashMap<String, Object>();
		//	searchMap.put("searchType", searchType);
		//	searchMap.put("searchValue", searchValue);
		//	mppList = procurementService.s
	//	}else {
			mppList = procurementService.readMpp();
	//	}
		model.addAttribute("mpp", mppList);
		return "mpp/mpp_main";
	}
	//자재소요계획 선택
	@GetMapping("mpp/mpp_selectMrp")
	public String selectMrp(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		List<MrpDTO> mrpList;
		
		if(searchType != null && searchValue != null && !searchValue.isEmpty()) {
			HashMap<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("searchType", searchType);
			searchMap.put("searchValue", searchValue);
			mrpList = mrpService.searchMrp(searchMap);
		} else {
			mrpList = mrpService.readMrp();
		}
		model.addAttribute("mrp", mrpList);
		
		return "mpp/mpp_selectMrp";
	}
	//부품조달계획 작성
	@GetMapping("mpp/mpp_getCreateMpp")
	public String getCreateMpp(@RequestParam("mrpCode")String mrpCode
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		List<MrpDTO> mrpList = mrpService.readMrpByMrpCode(mrpCode);
		String generatedMppCode = procurementService.generateNewMppCode();
		int mppVer = procurementService.countMppVer(generatedMppCode);
		
		MrpDTO mrp = mrpList.get(0); // 리스트에서 첫 번째 요소 꺼냄
//		System.out.println("prplNo 값: " + mrp.getPrplNo()); 
		
		model.addAttribute("mrpList", mrpList);
		model.addAttribute("mrp", mrpList.get(0));
		model.addAttribute("mppCode", generatedMppCode);
		model.addAttribute("today", LocalDate.now());
		model.addAttribute("mppVer", mppVer);
		
		System.out.println();
		return "mpp/mpp_createMpp";
	}
	//조달계획 등록
	@PostMapping("mpp/createMpp")
	public String createMpp(@ModelAttribute("mpp")ProcurementDTO procurementDTO
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		procurementService.createMpp(procurementDTO);
		
		return "redirect:/mpp/mpp_main";
	}
	//조달계획 상세보기
	@GetMapping("mpp/mpp_selectMpp")
	public String selectMpp(@RequestParam("mppNo")int mppNo
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		ProcurementDTO procurementDTO = procurementService.readMppByMppNo(mppNo);
		model.addAttribute("mpp", procurementDTO);
		
		String mrpCode = mrpService.getMrpCodeByMrpNo(procurementDTO.getMrpNo());
		
		List<MrpDTO> mrpList = mrpService.readMrpByMrpCode(mrpCode);
		model.addAttribute("mrpList", mrpList);
		
	    if (!mrpList.isEmpty()) {
	        model.addAttribute("mrp", mrpList.get(0));
	    }
		
//		System.out.println("✔"+procurementDTO);
		
		return "mpp/mpp_selectMpp";
	}
	//구매발주 진행
	@GetMapping("mpp/getCreatePurchaseOrder")
	public String createPurchaseOrder(@ModelAttribute("mpp") ProcurementDTO procurementDTO
			, @ModelAttribute("materials") MrpFormDTO mrpFormDTO
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
	    List<MrpDTO> selectedMaterials = mrpFormDTO.getMaterials();
	    ProcurementDTO mpp = procurementService.readMppByMppNo(procurementDTO.getMppNo());
	    MrpDTO mrpDTO = mrpService.getMrpByMrpNo(procurementDTO.getMrpNo()); 
	    CompanyDTO companyDTO = procurementService.getCompanyByEmpNo(procurementDTO.getEmpNo());
	    
	    List<MrpDTO> mrpList = new ArrayList<>();
	    List<MaterialDTO> materialList = new ArrayList<>();
	    List<SupplierDTO> supplierList = new ArrayList<>();
	    
	    for (MrpDTO item : selectedMaterials) {
	        MrpDTO mrp = mrpService.getMrpByMrpNo(item.getMrpNo());
	        MaterialDTO material = materialService.getMaterialByMaterialNo(mrp.getMaterialNo());
	        SupplierDTO supplier = supplierService.readSupplierBySupNo(material.getSupNo());

	        mrpList.add(mrp);
	        materialList.add(material);
	        supplierList.add(supplier);
	    }
	    
	    model.addAttribute("mrpList", mrpList);
	    model.addAttribute("mpp", mpp);
	    model.addAttribute("mrp", mrpDTO);
	    model.addAttribute("company", companyDTO);
	    model.addAttribute("material", materialList);
	    model.addAttribute("sup", supplierList.get(0));
		
//	    System.out.println("✔3"+selectedMaterials);
//	    System.out.println("✔4"+mpp);
//	    System.out.println("✔5"+mrpDTO);
	    System.out.println("✔6"+mrpList);
	    System.out.println("✔7"+materialList);
		return "mpp/mpp_createPurchaseOrder";
	}
	
	//구매발주등록
	@PostMapping("mpp/createPurchaseOrder")
	public String createPurchaseOrder(@ModelAttribute MrpFormDTO mrpFormDTO,
	                                  @RequestParam("emp_no") int empNo,
	                                  @RequestParam("purc_order_code") String purcOrderCode,
	                                  @RequestParam("purc_order_status") int purcOrderStatus,
	                                  HttpServletRequest request,
	                                  HttpSession session) throws Exception {

	    List<MrpDTO> mrpList = mrpFormDTO.getMaterials();

	    for (MrpDTO mrp : mrpList) {
	        PurchaseorderDTO order = new PurchaseorderDTO();

	        order.setMrp_no(mrp.getMrpNo());           // 자재소요계획 번호
	        order.setCont_no(mrp.getContNo());         // 계약 번호 (MrpDTO에 포함되어 있어야 함)
	        order.setEmp_no(empNo);
	        order.setPurc_order_code(purcOrderCode);
//	        order.setPurc_order_status(purcOrderStatus);
//	        order.setPurcOrderEtc(mrp.getPurcOrderEtc());   // 비고가 있다면

//	        purchaseorderService.register(order);
	    }

	    return "redirect:/mpp/mpp_main";
	}
	
	
}
