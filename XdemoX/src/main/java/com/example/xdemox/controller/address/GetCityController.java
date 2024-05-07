package com.example.xdemox.controller.address;

import com.example.xdemox.pojo.dto.CityDto;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.address.GetCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCityController {
    @Autowired
    GetCityService getCityService;

    @GetMapping("/api/city")
    @Cacheable(cacheNames = "province",key = "#id")
    public Result get(Integer id){

        return getCityService.getcity(id);
    }
}
