package kr.co.chill.incoming;

import java.util.List;
import java.util.Map;

public interface IncomingService {
	
	//창고별 자재리스트 전체조회
		List<IncomingDTO> material_storage(IncomingDTO incomingDTO);
		
		// 자재 입고예정
		List<IncomingDTO> expected(IncomingDTO incomingDTO);
	
		void materialInProcess(List<IncomingDTO> list);
		
	//material_handling에 필요한 기능
		List<IncomingDTO> searchMaterials(Map<String, Object> params);
	    void updatePurchaseOrderStatus(List<Integer> purcOrderNos);
	
}
