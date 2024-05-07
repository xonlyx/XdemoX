package com.example.xdemox.controller.orders.auction;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.auction.BidPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BidPriceController {

    @Autowired
    BidPriceService bidPriceService;

    @PostMapping("/api/order/auction/bid")
    public Result bid(Integer orderid, Integer masterid, Integer money) {
        return bidPriceService.bid(orderid, masterid, money);
    }

}
