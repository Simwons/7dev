package kr.co.chill.contract;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
	
	@Inject
	ContractDAO contractDAO;
	//전체조회
	@Override
	public List<ContractDTO> readContract() throws Exception {
		// TODO Auto-generated method stub
		return contractDAO.readContract();
	}
	//선택조회(상세보기)
	@Override
	public ContractDTO readContractByContNo(int contNo) throws Exception {
		// TODO Auto-generated method stub
		return contractDAO.readContractByContNo(contNo);
	}
	//계약번호로 선택조회
	@Override
	public List<ContractDTO> searchContract(Map<String, Object> searchMap) throws Exception {
		// TODO Auto-generated method stub
		return contractDAO.searchContract(searchMap);
	}
	//등록
	@Override
	public void createContract(ContractDTO contractDTO) throws Exception {
		// TODO Auto-generated method stub
	    String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	    String baseCode = "CT" + today;

	    int countToday = contractDAO.countContractToday(today);
	    String newContCode = baseCode + String.format("%02d", countToday + 1);

	    contractDTO.setContCode(newContCode);
		contractDAO.createContract(contractDTO);
	}
	//단가등록
	@Override
	public void createMprice(ContractDTO contractDTO) throws Exception {
		// TODO Auto-generated method stub
		contractDAO.createMprice(contractDTO);
	}
	
}
