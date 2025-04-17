package kr.co.chill.inventory.dto;

import lombok.Data;

@Data
public class InventoryReportDTO {
    private String materialType;
    private String plantCode;
    private String stockLocation;
    private Integer openingStockQty;
    private Integer periodNetChangeQty;
    private Integer stockQty;
    private Long openingStockAmount;
    private Long inventoryAmount;
    private Long periodNetChangeAmount;
}