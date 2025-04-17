package kr.co.chill.incoming;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomingServiceImpl implements IncomingService{
	
	@Autowired
	private IncomingDAO incomingDAO;
	
	 

	@Override
	public List<IncomingDTO> material_storage(IncomingDTO DTO) {
		// TODO Auto-generated method stub
	
		return incomingDAO.material_storage(DTO);
	}
	
	@Override
	public List<IncomingDTO> expected(IncomingDTO DTO) {
		// TODO Auto-generated method stub
		
		return incomingDAO.expected(DTO);
	}

	@Override
	public void materialInProcess(List<IncomingDTO> list) {
		// TODO Auto-generated method stub
		System.out.println("넘어온 list : " + list);  // null 체크
		for(IncomingDTO dto : list) {
			System.out.println("dto : " + dto);  // dto 안 값 확인
			int count = incomingDAO.checkMaterialStorage(dto);
			
			if(count>0) {
				//창고에 이미 존재하면 수량만 업데이트
				
				incomingDAO.updateMaterialStorage(dto);
			}else {
				//창고에 존재하지 않으면 새로 추가
				
				if(dto.getMstorage_code().equals("MW002")) {
					dto.setEmp_no(3);
				}else if(dto.getMstorage_code().equals("MW001")) {
					dto.setEmp_no(4);
				}else if(dto.getMstorage_code().equals("MW003")) {
					dto.setEmp_no(5);
				}else {
					 int randomEmpNo = (int)(Math.random() * 7) + 1; // 1~7 사이 랜덤
					    dto.setEmp_no(randomEmpNo);
				}
				
				if(dto.getMstorage_code().equals("MW002")) {
					dto.setProduct_no(1);
				}else if(dto.getMstorage_code().equals("MW001")) {
					dto.setProduct_no(2);
				}else if(dto.getMstorage_code().equals("MW003")) {
					dto.setProduct_no(3);
				}
				
				incomingDAO.insertMaterialStorage(dto);
			}
			//창고 입고 state값 변경
			incomingDAO.updateMaterialState(dto);
		}
	}

	
	
	//material_handling에 필요한 기능
	 @Override
	    public List<IncomingDTO> searchMaterials(Map<String, Object> params) {
	        return incomingDAO.searchMaterials(params);
	    }

	    @Override
	    public void updatePurchaseOrderStatus(List<Integer> purcOrderNos) {
	        incomingDAO.updatePurchaseOrderStatus(purcOrderNos);
	    }

	
}	
