package kr.co.chill.contract;

import java.util.List;
import java.util.Map;

public interface ContractDAO {
	//전체조회
	List<ContractDTO> readContract() throws Exception;
	//선택조회(상세보기)
	ContractDTO readContractByContNo(int contNo) throws Exception;
	//계약번호로 선택조회
	List<ContractDTO> searchContract(Map<String, Object> searchMap) throws Exception;
	//등록
	void createContract(ContractDTO contractDTO) throws Exception;
	//단가등록
	void createMprice(ContractDTO contractDTO) throws Exception;
	//오늘계약 갯수 세기
	int countContractToday(String todayDate) throws Exception;
}
