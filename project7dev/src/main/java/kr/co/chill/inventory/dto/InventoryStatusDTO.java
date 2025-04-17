package kr.co.chill.inventory.dto;

import lombok.Data;

@Data
public class InventoryStatusDTO {
    private String materialCode;
    private String materialDesc;
    private String plantCode;
    private String stockLocation;
    private Integer openingStock;
    private Integer periodNetChange;
    private Integer stockQty;
}