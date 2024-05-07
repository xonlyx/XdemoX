package com.example.xdemox.controller.customer;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.GetMyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMyAddressController {
    @Autowired
    GetMyAddressService getMyAddressService;

    @PostMapping("/api/customer/address/get")
    public Result getMyAddress(Integer customerId) {
        return getMyAddressService.getMyAddress(customerId);
    }
}
