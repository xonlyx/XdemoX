package com.example.xdemox.service.customer;

import com.example.xdemox.pojo.entity.Result;

public interface FinishOrderService {
    Result finishOrder(String orderId);
}
