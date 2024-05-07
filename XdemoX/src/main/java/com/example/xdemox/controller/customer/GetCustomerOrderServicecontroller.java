package com.example.xdemox.controller.customer;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.GetCustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCustomerOrderServicecontroller {
    @Autowired
    GetCustomerOrderService getCustomerOrderService;

    @GetMapping("/api/customer/order")
    public Result getCustomerOrder(Integer id){
        return getCustomerOrderService.getMyOrder(id);
    }
}
