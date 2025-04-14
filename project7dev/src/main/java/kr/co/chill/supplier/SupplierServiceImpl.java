package kr.co.chill.supplier;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Inject
	SupplierDAO supplierDAO;
	//전체조회
	@Override
	public List<SupplierDTO> readSupplier() throws Exception {
		// TODO Auto-generated method stub
		return supplierDAO.readSupplier();
	}
	//선택조회(상세보기
	@Override
	public SupplierDTO readSupplierBySupNo(int supNo) throws Exception {
		// TODO Auto-generated method stub
		return supplierDAO.readSupplierBySupNo(supNo);
	}
	//거래처정보 검색조회
	@Override
	public List<SupplierDTO> searchSupplier(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return supplierDAO.searchSupplier(searchMap);
	}
	//사업자번호로 거래처 가져오기
	@Override
	public List<SupplierDTO> getSupplierBySupRegNo(String supRegNo) throws Exception {
		// TODO Auto-generated method stub
		return supplierDAO.getSupplierBySupRegNo(supRegNo);
	}
	//신규등록
	@Override
	public void createSupplier(SupplierDTO supplierDTO) throws Exception {
		// TODO Auto-generated method stub
		supplierDAO.createSupplier(supplierDTO);
	}
	//수정
	@Override
	public void updateSupplier(SupplierDTO supplierDTO) throws Exception {
		// TODO Auto-generated method stub
		supplierDAO.updateSupplier(supplierDTO);
	}
	//삭제
	@Override
	public void deleteSupplier(int supNo) throws Exception {
		// TODO Auto-generated method stub
		supplierDAO.deleteSupplier(supNo);
	}

	
	
}
