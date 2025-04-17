package kr.co.chill.inventory.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

@Data
public class MaterialDocumentDTO {
    private Integer documentNo;
    private String materialCode;
    private String materialDesc;
    private Integer quantity;
    private String plantCode;
    private String stockLocation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date documentDate;
    private String documentType;
}