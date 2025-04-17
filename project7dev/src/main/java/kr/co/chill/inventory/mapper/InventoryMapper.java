package kr.co.chill.inventory.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import kr.co.chill.inventory.dto.InventoryReportDTO;
import kr.co.chill.inventory.dto.InventoryStatusDTO;
import kr.co.chill.inventory.dto.MaterialDocumentDTO;

@Mapper
public interface InventoryMapper {
    List<InventoryStatusDTO> selectInventoryStatus(Map<String, Object> params);
    List<MaterialDocumentDTO> selectMaterialDocuments(Map<String, Object> params);
    List<InventoryReportDTO> selectInventoryReport(Map<String, Object> params);
}