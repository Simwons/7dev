package kr.co.chill.issuing;

import java.util.List;

public interface IssuingDAO {

	List<IssuingDTO> productlist();

	List<IssuingDTO> materialstock(int product_no, int product_cnt);

	IssuingDTO productOne(int product_no);

	List<InoutStorageDTO> storageIO(List<IssuingDTO> materialstock);

}
