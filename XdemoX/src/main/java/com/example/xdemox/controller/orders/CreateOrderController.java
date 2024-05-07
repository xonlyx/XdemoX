package com.example.xdemox.controller.orders;

import com.example.xdemox.pojo.dto.CreateOrderDTO;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.CreateOrderService;
import com.example.xdemox.utils.AliOss;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
public class CreateOrderController {
    @Autowired
    CreateOrderService createOrderService;
    @Autowired
    AliOss aliOss;

    @PostMapping("/api/orders")

    public Result create(CreateOrderDTO createOrderDTO ){
        String address = createOrderDTO.getAddress();
        Integer city = createOrderDTO.getCity();
        Integer kind = createOrderDTO.getKind();

        Integer userid = createOrderDTO.getUserid();
        String deadline = createOrderDTO.getDeadline();
        Integer province = createOrderDTO.getProvince();
        MultipartFile photo = createOrderDTO.getPhoto();
        Integer money = createOrderDTO.getMoney();
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time=LocalDateTime.parse(deadline, df3);
        String url= null;
        log.info(String.valueOf(ObjectUtils.isEmpty(photo) || photo.getSize() <= 0));
        // aliyun oss 处理照片
        if(ObjectUtils.isEmpty(photo) || photo.getSize() <= 0){}
        else{
            try {
                url = aliOss.upload(photo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        LocalDateTime now = LocalDateTime.now();
        return createOrderService.create(userid,time,kind,url,province,city,address,money,now);
    }

}
