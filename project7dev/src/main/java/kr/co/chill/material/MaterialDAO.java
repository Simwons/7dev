package kr.co.chill.material;

import java.util.List;
import java.util.Map;

public interface MaterialDAO {
	//전체조회
	List<MaterialDTO> readMaterial() throws Exception;
	//검색조회
	List<MaterialDTO> searchMaterial(Map<String, Object> searchMap) throws Exception;
	//부품코드로 부품조회
	List<MaterialDTO> getMaterialByMaterialCode(Map<String, Object> searchMap) throws Exception;
	//부품 내의 제품코드로 해당부품이 어디에 쓰이는지 조회용(bom)
	List<MaterialDTO> getMaterialByProductNo(int productNo) throws Exception;
	//부품번호로 부품조회
	MaterialDTO getMaterialByMaterialNo(int materialNo)throws Exception;
	//등록
	void createMaterial(MaterialDTO materialDTO) throws Exception;
	//수정: 사용되는 제품(BOM작성 시)
	void updateMaterialProductRef(Map<String, Object> updateMap) throws Exception;
	//수정: 계약서 작성 시 
	void updateMaterialContract(MaterialDTO materialDTO) throws Exception;
	//전체수정
	void updateMaterial(MaterialDTO materialDTO) throws Exception;
	//삭제
	void deleteMaterial(int materialNo) throws Exception;
}
