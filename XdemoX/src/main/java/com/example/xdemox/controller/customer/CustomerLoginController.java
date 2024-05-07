package com.example.xdemox.controller.customer;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerLoginController {

    @Autowired
    CustomerLoginService customerLoginService;

    @PostMapping("/api/customer/login")
    public Result login(String telephone, String password) {
        return customerLoginService.login(telephone, password);
    }
}
