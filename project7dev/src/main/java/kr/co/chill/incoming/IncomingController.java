package kr.co.chill.incoming;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.chill.HomeController;


@Controller
public class IncomingController {
	
	private static final Logger logger = LoggerFactory.getLogger(IncomingController.class);
	
	@Autowired
	private IncomingService inService;
	
	
	//자재창고에 있는 자재리스트확인
    @GetMapping(value="incoming/material_storage")
    public ModelAndView material_storage(IncomingDTO incomingDTO
    		, @RequestParam(value = "material_code", required = false) String code
    		, HttpServletRequest request) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView(); 
        request.setCharacterEncoding("UTF-8");
    
        String itemCode = code;
        
        // 만약 전부 '선택' 이거나 아무것도 없으면 material_code null 처리
        if(itemCode==null) {
            incomingDTO.setMaterial_code(null);  // 조건 안걸리게
        } else {
            incomingDTO.setMaterial_code(itemCode);  // 조건 걸리게
        }
    	// 날짜 범위도 DTO에 넣기
    	incomingDTO.setMaterial_in_date(request.getParameter("start_date"));
    	incomingDTO.setMaterial_in_date(request.getParameter("end_date"));

       List<IncomingDTO> material_storage = inService.material_storage(incomingDTO);
       
       logger.info("리스트:" + material_storage);
       mav.addObject("mstorage_code", incomingDTO.getMstorage_code());
       mav.addObject("material_storage", material_storage);
       mav.setViewName("incoming/material_storage");
        return mav;
    }
    
    
    // 입고예정 자재리스트
    @GetMapping(value="incoming/expected")
    public ModelAndView expected(IncomingDTO incomingDTO
    		, @RequestParam(value = "material_code", required = false) String code
    		, @RequestParam(value = "material_in_state", required = false, defaultValue = "0") int material_in_state
    		, HttpServletRequest request) throws UnsupportedEncodingException {
    	ModelAndView mav = new ModelAndView();
    	request.setCharacterEncoding("UTF-8");
    	
           String itemCode = code;
           
           // 만약 전부 '선택' 이거나 아무것도 없으면 material_code null 처리
           if(itemCode==null) {
               incomingDTO.setMaterial_code(null);  // 조건 안걸리게
           } else {
               incomingDTO.setMaterial_code(itemCode);  // 조건 걸리게
           }
           // material_in_state의 값에 따른 검색
           incomingDTO.setMaterial_in_state(material_in_state);
           
     // 날짜 범위도 DTO에 넣기
    	incomingDTO.setMaterial_in_date(request.getParameter("start_date"));
    	incomingDTO.setMaterial_in_date(request.getParameter("end_date"));
    	
    	
    	List<IncomingDTO> expected = inService.expected(incomingDTO);
    	
    	logger.info("material_code: " + incomingDTO.getMaterial_code());
    	mav.addObject("mstorage_code", incomingDTO.getMstorage_code());
    	mav.addObject("material_in_state", material_in_state);
    	mav.addObject("expected", expected);
    	mav.setViewName("incoming/expected");
    	return mav;
    }
    
    
    	// 입고처리
	   @PostMapping("incoming/expected/inProcess")
	  public String materialInProcess(@ModelAttribute IncomingWrapperList wrapper) {
	   	List<IncomingDTO> list = wrapper.getIncomingDTOList();
	   	System.out.println("incomingDTOListWrapper:" + wrapper);
	   	for (IncomingDTO dto : list) {
	   	    System.out.println("입고 처리 자재: " + dto.getMaterial_name() + ", 창고: " + dto.getMstorage_code() + "ms_in_no:" + dto.getMaterial_in_no());
	   	    
	   	}
	       inService.materialInProcess(list);
	       return "redirect:/incoming/expected";
	   }
	
	   
	   
	   //material_handling
	   @GetMapping("incoming/material_handling")
	    public String getMaterials(
	        @RequestParam(required = false) String order_code,
	        @RequestParam(required = false) Integer material_in_state,
	        @RequestParam(required = false) Integer purc_order_status,
	        @RequestParam(required = false) String mstorage_in_date,
	        @RequestParam(required = false) String start_date,
	        @RequestParam(required = false) String end_date,
	        Model model) {

	        Map<String, Object> params = new HashMap<>();
	        params.put("order_code", order_code);
	        params.put("material_in_state", material_in_state);
	        params.put("purc_order_status", purc_order_status);
	        params.put("mstorage_in_date", mstorage_in_date);
	        params.put("start_date", start_date);
	        params.put("end_date", end_date);

	        List<IncomingDTO> list = inService.searchMaterials(params);
	        model.addAttribute("material_handling", list);
	        model.addAttribute("material_in_state", material_in_state);
	        model.addAttribute("purc_order_status", purc_order_status);
	        model.addAttribute("mstorage_in_date", mstorage_in_date);

	        return "incoming/material_handling";
	    }

	    // 구매마감 처리
	    @PostMapping("incoming/purchaseClose")
	    public String closePurchase(@RequestParam("purc_order_no") List<Integer> orderNo) {
	    	inService.updatePurchaseOrderStatus(orderNo);
	        return "redirect:incoming/material_handling";
	    }
	    
	    
	 // 거래명세서 목록
		@GetMapping(value="incoming/tp_list")
		public String tp_list(Model model) throws Exception {
			
			logger.info("거래명세서 조회");
			
			List<Trans_paperDTO> tp_list = inService.tp_list();
			model.addAttribute("tp_list", tp_list);
			
			
			return "incoming/tp_list";
			
		}

		
		// 거래명세서 상세보기
		@GetMapping("incoming/tp_detail")
		public String tp_detail(@RequestParam("trans_paper_no") int trans_paper_no, Model model) throws Exception {
		
			logger.info("거래명세서 상세보기");
			
			Trans_paperDTO trans_PaperDTO = inService.tp_detail(trans_paper_no);
			
			model.addAttribute("transPaper", trans_PaperDTO );
			
			return "incoming/tp_detail";
		}
		
		
		// 현황관리 리포트
		@RequestMapping("incoming/status_list")
		public String status_list(HttpServletRequest request, Model model) {
			Map<String, Object> paramMap = new HashMap<>();
			
			paramMap.put("sup", request.getParameter("sup"));
			paramMap.put("material_code", request.getParameter("material_code"));
	        paramMap.put("material_name", request.getParameter("material_name"));
	        paramMap.put("purc_order_reg_date", request.getParameter("purc_order_reg_date"));
	        paramMap.put("purc_order_code", request.getParameter("purc_order_code"));
	        paramMap.put("mstorage_code", request.getParameter("mstorage_code"));

	        List<StatusDTO> status_list = inService.status_list(paramMap);
			
	        model.addAttribute("status_list", status_list);
	        model.addAttribute("servertime", new java.util.Date());
	        model.addAttribute("totalCount", status_list.size());
			
			return "incoming/status_list";	
			
		}    
	    
	    
	    
	    
	    
	  
}
