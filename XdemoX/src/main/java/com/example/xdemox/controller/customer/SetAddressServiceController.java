package com.example.xdemox.controller.customer;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.SetAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetAddressServiceController {
    @Autowired
    SetAddressService setAddressService;

    @PostMapping("/api/setaddress")
    public Result setaddress(String address, Integer city_id, Integer province_id, Integer user_id) {

        return setAddressService.setaddress(address, city_id, province_id, user_id);
    }
}
