package kr.co.chill.incoming;

import java.util.List;

public interface IncomingDAO {
	//창고별 자재리스트 전체조회
	List<IncomingDTO> material_storage(IncomingDTO incomingDTO);
	
	//자재 입고예정 리스트 전체조회
	List<IncomingDTO> expected(IncomingDTO incomingDTO);
	//자재 창고로 입고
	int inMaterial(IncomingDTO incomingDTO);
	
	//자재 반품
	int outMaterial(IncomingDTO incomingDTO);
	//
}
