package com.example.xdemox.service.Orders.auction;

import com.example.xdemox.pojo.entity.Result;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDateTime;

public interface CreateAuctionOrderService {
    public Result create(Integer userid,LocalDateTime time,Integer kind,String url,Integer province,Integer city,String address,Integer money,LocalDateTime realnow);
}
