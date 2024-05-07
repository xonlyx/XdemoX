package com.example.xdemox.service.customer;

import com.example.xdemox.pojo.entity.Result;

public interface EvaluteOrderService {
    public Result evaluteOrder(String orderId, String comment ,Integer socre);
}
