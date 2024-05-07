package com.example.xdemox.controller.admin;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.admin.GetCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCustomerController {

    @Autowired
    GetCustomerService getCustomerService;

    @GetMapping("/api/admin/getCustomer")
    Result getCustomer(int size, int page){
        return Result.success(getCustomerService.getCustomer(size,page));

    }
}
