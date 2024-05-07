package com.example.xdemox.controller.customer;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.EvaluteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EvaluteOrderController {
    @Autowired
    EvaluteOrderService evaluteOrderService;

    @PostMapping("/api/customer/evaluteOrder")
    public Result evaluteOrder(String orderId, String comment , Integer socre){
        return evaluteOrderService.evaluteOrder(orderId,comment,socre);
    }
}
