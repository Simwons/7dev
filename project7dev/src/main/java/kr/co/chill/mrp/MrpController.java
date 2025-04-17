package kr.co.chill.mrp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import kr.co.chill.productionPlanning.ProductionPlanningDTO;
import kr.co.chill.productionPlanning.ProductionPlanningService;

@Controller
public class MrpController {
	
	@Inject
	MrpService mrpService;
	
	@Inject
	ProductionPlanningService prplService;
	
	@Inject
	MaterialService materialService;
	
	//메인화면
	@GetMapping("mrp/mrp_main")
	public String mrpMain(@RequestParam(value = "searchType", required = false)String searchType
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
		System.out.println(mrpList);
		
		return "mrp/mrp_main";
	}
	//prpl선택
	@GetMapping("mrp/mrp_selectPrpl")
	public String searchPrpl(@RequestParam(value = "searchType", required = false)String searchType
			, @RequestParam(value = "searchValue", required = false)String searchValue
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		List<ProductionPlanningDTO> prplList;
		if(searchType!=null && searchValue != null && !searchValue.isEmpty()) {
			HashMap<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("searchType", searchType);
			searchMap.put("searchValue", searchValue);
			prplList = prplService.searchProductionPlanning(searchMap);
		}else {
			prplList = prplService.readProductionPlanning();
		}
		model.addAttribute("productionPlanning", prplList);
		return "mrp/mrp_selectPrpl";
	}
	//선택한 제품 mrp 작성
	@GetMapping("mrp/mrp_getCreateMrp")
	public String getCreateMrp(@RequestParam("prplNo")int prplNo
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		ProductionPlanningDTO prpl = prplService.readProductionPlanningByPrplNo(prplNo);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dueDate = sdf.parse(prpl.getPrplDueDate());

		Calendar cal = Calendar.getInstance();
		cal.setTime(dueDate);
		cal.add(Calendar.DATE, -prpl.getPrplLeadtime());

		String mrpDueDate = sdf.format(cal.getTime());
		
		model.addAttribute("prpl", prpl);
		model.addAttribute("mrpDueDate", mrpDueDate);
		
		return "mrp/mrp_createMrp";
	}
	//자재선택 모달 띄우기
	@GetMapping("/material/search")
	public String searchMaterial(Model model
			, HttpSession session
			, HttpServletRequest request) throws Exception {
	    List<MaterialDTO> materialList = materialService.readMaterial();
	    model.addAttribute("materialList", materialList);
	    return "mrp/material_modal";
	}
	//mrp등록
	@PostMapping("mrp/createMrp")
	public String createMrp(@ModelAttribute("mrp") MrpFormDTO mrpFormDTO
			, HttpSession session
			, HttpServletRequest request) throws Exception {
		List<MrpDTO> materials = mrpFormDTO.getMaterials();
		
		for(MrpDTO mrpDTO : materials) {
			mrpDTO.setEmpNo(mrpFormDTO.getEmpNo());
			mrpDTO.setProductNo(mrpFormDTO.getProductNo());
			mrpDTO.setMrpDueDate(mrpFormDTO.getMrpDueDate());
			mrpService.createMrp(mrpDTO);
		}
		
		return "redirect:/mrp/mrp_main";
	}
	
	//자재소요계획 상세페이지
	@GetMapping("mrp/mrp_selectMrp")
	public String selectMrp(@RequestParam("mrpCode")String mrpCode
			, HttpSession session
			, HttpServletRequest request
			, Model model) throws Exception {
		List<MrpDTO> mrpList = mrpService.readMrpByMrpCode(mrpCode);
		model.addAttribute("mrpList", mrpList);
		model.addAttribute("mrp", mrpList.get(0));
		return "mrp/mrp_selectMrp";
	}
	
}
