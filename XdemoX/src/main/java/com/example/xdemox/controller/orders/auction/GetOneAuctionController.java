package com.example.xdemox.controller.orders.auction;


import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.auction.GetOneAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOneAuctionController {

    @Autowired
    GetOneAuctionService getOneAuctionService;

    @PostMapping("/api/order/auction/getone")
    public Result  getOneAuction(Integer OrderId){

        return getOneAuctionService.getone(OrderId);

    }


}
