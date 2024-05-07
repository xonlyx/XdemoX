package com.example.xdemox.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuctionOrderDTO {
    //private Integer orderid;
    //private Integer masterid;
    private Integer userid;
    private  Integer moneyplus10;
    private MultipartFile photo;

}
