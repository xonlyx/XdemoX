package com.example.xdemox.controller.helper;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.helper.StringToInt_of_Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringToInt_of_ProvinceController {
    @Autowired
    StringToInt_of_Province StringToInt_of_Province;
    @GetMapping("/api/helper/province")
    public Result StringToInt_of_Province(String province){
        return StringToInt_of_Province.StringToInt_of_Province(province);
    }
}
