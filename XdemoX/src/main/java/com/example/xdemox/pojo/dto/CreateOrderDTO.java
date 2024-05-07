package com.example.xdemox.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDTO {

    Integer userid;
    String deadline;
    Integer kind;
    MultipartFile photo;
    Integer province;
    Integer city;
    String address;
    Integer money;
}
