// kr.co.chill.inventory.dto.InventoryParamDTO.java
package kr.co.chill.inventory.dto;

import lombok.Data;

@Data
public class InventoryParamDTO {

    private String startDate; // Date -> String 변경
    private String endDate;   // Date -> String 변경

    private String queryMonthFrom;
    private String queryMonthTo;

    private String materialCodeFrom;
    private String materialCodeTo;
    private String plantCodeFrom;
    private String plantCodeTo;
    private String storageCodeFrom;
    private String storageCodeTo;

    private String materialTypeFrom;
    private String materialTypeTo;
}