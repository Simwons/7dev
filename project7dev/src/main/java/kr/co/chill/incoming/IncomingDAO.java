package kr.co.chill.incoming;

import java.util.List;
import java.util.Map;

public interface IncomingDAO {
	//창고별 자재리스트 전체조회 
	List<IncomingDTO> material_storage(IncomingDTO incomingDTO);
	
	// 자재 입고예정
	List<IncomingDTO> expected(IncomingDTO incomingDTO);
	
	// 창고에 입고예정인 자재가 이미 존재하는지 확인
	int checkMaterialStorage(IncomingDTO incomingDTO);
	// 창고에 자재가 존재하지 않는다면 새로 추가
	int insertMaterialStorage(IncomingDTO incomingDTO);
	// 창고에 자재가 존재하면 수량추가
	int updateMaterialStorage(IncomingDTO incomingDTO);
	// 자재예정에서 입고되면 state값 0에서 1로 변경
	int updateMaterialState(IncomingDTO incomingDTO);

	//material_handling 의 필요한 기능
	List<IncomingDTO> searchMaterials(Map<String, Object> params);
    void updatePurchaseOrderStatus(List<Integer> purcOrderNos);
}
