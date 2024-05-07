package com.example.xdemox.controller.orders.auction;

import com.example.xdemox.pojo.dto.AuctionOrderDTO;
import com.example.xdemox.pojo.dto.CreateOrderDTO;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.CreateOrderService;
import com.example.xdemox.service.Orders.auction.CreateAuctionOrderService;
import com.example.xdemox.service.Orders.auction.GetDistinctOrderService;
import com.example.xdemox.utils.AliOss;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class CreateAuctionOrderController {
    @Autowired
    CreateAuctionOrderService createAuctionOrderService;
    @Autowired
    CreateOrderService createOrderService;
    @Autowired
    AliOss aliOss;

    @PostMapping("/api/order/auction")

    public Result create(CreateOrderDTO createOrderDTO) {
        String address = createOrderDTO.getAddress();
        Integer city = createOrderDTO.getCity();
        Integer kind = createOrderDTO.getKind();
        Integer userid = createOrderDTO.getUserid();
        String deadline = createOrderDTO.getDeadline();
        Integer province = createOrderDTO.getProvince();
        MultipartFile photo = createOrderDTO.getPhoto();

        Integer money = createOrderDTO.getMoney();
        if (deadline.isEmpty()) {
            deadline = "9999-12-31 00:00:00";
        }
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(deadline, df3);

        String url = null;
        //log.info(String.valueOf(ObjectUtils.isEmpty(photo) || photo.getSize() <= 0));
        if (ObjectUtils.isEmpty(photo) || photo.getSize() <= 0) {
        } else {
            try {
                url = aliOss.upload(photo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        LocalDateTime realnow = LocalDateTime.parse(format, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //LocalDateTime time=LocalDateTime.parse(deadline, df3);
        log.info("===time:" + realnow);

        return createAuctionOrderService.create(userid, time, kind, url, province, city, address, money, realnow);

    }

}
