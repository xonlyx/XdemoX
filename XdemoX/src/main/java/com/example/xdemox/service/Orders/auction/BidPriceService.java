package com.example.xdemox.service.Orders.auction;

import com.example.xdemox.pojo.entity.Result;

public interface BidPriceService {

    public Result bid(Integer orderid, Integer masterid, Integer money);

}
