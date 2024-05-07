package com.example.xdemox.controller.customer;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.FinishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinishOrderServiceController {

    @Autowired
    FinishOrderService finishOrderService;

    @PutMapping("/api/customer/finishOrder")
    public Result finishOrder(String orderId){
        return finishOrderService.finishOrder(orderId);
    }

}
