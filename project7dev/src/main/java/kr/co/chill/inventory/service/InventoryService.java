package kr.co.chill.inventory.service;

import java.util.List;
import kr.co.chill.inventory.dto.InventoryParamDTO;
import kr.co.chill.inventory.dto.InventoryReportDTO;
import kr.co.chill.inventory.dto.InventoryStatusDTO;
import kr.co.chill.inventory.dto.MaterialDocumentDTO;

public interface InventoryService {
    List<InventoryStatusDTO> getInventoryStatus(InventoryParamDTO params);
    List<MaterialDocumentDTO> getMaterialDocuments(InventoryParamDTO params);
    List<InventoryReportDTO> getInventoryReport(InventoryParamDTO params);
}