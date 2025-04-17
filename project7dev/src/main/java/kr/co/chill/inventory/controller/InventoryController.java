package kr.co.chill.inventory.controller;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.co.chill.inventory.dto.InventoryParamDTO;
import kr.co.chill.inventory.dto.InventoryReportDTO;
import kr.co.chill.inventory.dto.InventoryStatusDTO;
import kr.co.chill.inventory.dto.MaterialDocumentDTO;
import kr.co.chill.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Inject
    private InventoryService inventoryService;

    @GetMapping("/status")
    public ResponseEntity<?> getInventoryStatus(@ModelAttribute InventoryParamDTO params) {
        logger.info("Requesting inventory status with params: {}", params);
        try {
            List<InventoryStatusDTO> result = inventoryService.getInventoryStatus(params);
            logger.info("Return inventory status data size: {}", (result != null ? result.size() : "null"));
            if (logger.isDebugEnabled()) {
                 logger.debug("Returning inventory status data: {}", result);
            }
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
             logger.error("Error fetching inventory status (Bad Request): {}", e.getMessage());
             return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Error fetching inventory status: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 내부 오류가 발생했습니다.");
        }
    }

    @GetMapping("/documents")
    public ResponseEntity<?> getMaterialDocuments(@ModelAttribute InventoryParamDTO params) {
         logger.info("Requesting material documents with params: {}", params);
         try {
            List<MaterialDocumentDTO> result = inventoryService.getMaterialDocuments(params);
            logger.info("Return material documents data size: {}", (result != null ? result.size() : "null"));
             if (logger.isDebugEnabled()) {
                 logger.debug("Returning material documents data: {}", result);
            }
            return ResponseEntity.ok(result);
         } catch (IllegalArgumentException e) {
             logger.warn("Bad request for material documents: {}", e.getMessage());
             return ResponseEntity.badRequest().build();
         } catch (Exception e) {
            logger.error("Error fetching material documents: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 내부 오류가 발생했습니다.");
        }
    }

    @GetMapping("/report")
    public ResponseEntity<?> getInventoryReport(@ModelAttribute InventoryParamDTO params) {
        logger.info("Requesting inventory report with params: {}", params);
        try {
            List<InventoryReportDTO> result = inventoryService.getInventoryReport(params);
            logger.info("Return inventory report data size: {}", (result != null ? result.size() : "null"));
             if (logger.isDebugEnabled()) {
                 logger.debug("Returning inventory report data: {}", result);
            }
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
             logger.error("Error fetching inventory report (Bad Request): {}", e.getMessage());
             return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Error fetching inventory report: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 내부 오류가 발생했습니다.");
        }
    }
}