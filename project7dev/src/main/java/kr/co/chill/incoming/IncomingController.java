package kr.co.chill.incoming;

import java.io.UnsupportedEncodingException;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.chill.HomeController;

@Controller
public class IncomingController {
	
	private static final Logger logger = LoggerFactory.getLogger(IncomingController.class);
	
	@Autowired
	private IncomingService inService;
	
	
	//자재창고에 있는 자재리스트확인
    @GetMapping(value="/material_storage")
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
       mav.setViewName("material_storage");
        return mav;
    }
    
    
    // 입고예정 자재리스트
    @GetMapping(value="/expected")
    public ModelAndView expected(IncomingDTO incomingDTO
    		, @RequestParam(value = "material_code", required = false) String code
    		, @RequestParam(value = "state", required = false, defaultValue = "0") int state
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

           // state의 값에 따른 검색
           incomingDTO.setState(state);
           
     // 날짜 범위도 DTO에 넣기
    	incomingDTO.setMaterial_in_date(request.getParameter("start_date"));
    	incomingDTO.setMaterial_in_date(request.getParameter("end_date"));
    	
    	
    	List<IncomingDTO> expected = inService.expected(incomingDTO);
    	
    	logger.info("material_code: " + incomingDTO.getMaterial_code());
    	mav.addObject("mstorage_code", incomingDTO.getMstorage_code());
    	mav.addObject("state", state);
    	mav.addObject("expected", expected);
    	mav.setViewName("expected");
    	return mav;
    }
    
    
    	// 입고처리
	   @PostMapping("/expected/inProcess")
	  public String materialInProcess(@ModelAttribute IncomingWrapperList wrapper) {
	   	List<IncomingDTO> list = wrapper.getIncomingDTOList();
	   	System.out.println("incomingDTOListWrapper:" + wrapper);
	   	for (IncomingDTO dto : list) {
	   	    System.out.println("입고 처리 자재: " + dto.getMaterial_name() + ", 창고: " + dto.getMstorage_code() + "ms_in_no:" + dto.getMaterial_in_no());
	   	    
	   	}
	       inService.materialInProcess(list);
	       return "redirect:/expected";
	   }
	

}
