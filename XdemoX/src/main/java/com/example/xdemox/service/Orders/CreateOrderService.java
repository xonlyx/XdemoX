package com.example.xdemox.service.Orders;

import com.example.xdemox.pojo.entity.Result;

import java.time.LocalDateTime;

public interface CreateOrderService {
    public Result create(Integer userid , LocalDateTime deadline ,Integer kind ,String photo, Integer province ,Integer city,String address,Integer moneyplus10 ,LocalDateTime now);

}
