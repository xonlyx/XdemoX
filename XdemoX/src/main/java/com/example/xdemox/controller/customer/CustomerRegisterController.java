package com.example.xdemox.controller.customer;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.CustomerRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRegisterController {
    @Autowired
    CustomerRegisterService customerRegisterService;

    @PostMapping("/api/customer/register")
    public Result register(Integer telephone, String password){
        return customerRegisterService.register(telephone, password);
    }
}
