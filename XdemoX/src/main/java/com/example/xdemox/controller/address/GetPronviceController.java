package com.example.xdemox.controller.address;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.address.GetProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPronviceController {

    @Autowired
    GetProvinceService getProvinceService;

    @GetMapping("/api/province")
    @Cacheable(cacheNames = "province" )
    public Result get(){
        return getProvinceService.getpronice();
    }

}
