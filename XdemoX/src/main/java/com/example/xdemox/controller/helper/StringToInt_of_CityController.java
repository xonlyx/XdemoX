package com.example.xdemox.controller.helper;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.helper.StringToInt_of_City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringToInt_of_CityController {
    @Autowired
    StringToInt_of_City stringToInt_of_City;

    @GetMapping("/api/helper/city")
    public Result StringToInt_of_City(String city, Integer province_id){
        return stringToInt_of_City.StringToInt_of_City(city,province_id);
    }
}
