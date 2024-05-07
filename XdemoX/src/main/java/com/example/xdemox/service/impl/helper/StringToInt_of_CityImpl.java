package com.example.xdemox.service.impl.helper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.CityMapper;
import com.example.xdemox.pojo.entity.City;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.helper.StringToInt_of_City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringToInt_of_CityImpl implements StringToInt_of_City {
    @Autowired
    CityMapper cityMapper;
    @Override
    public Result StringToInt_of_City(String city,Integer province_id) {
        QueryWrapper<City> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("pid",province_id).eq("city",city);
        City city1 = cityMapper.selectOne(queryWrapper);
        if (city1==null){
            return Result.error("打错字了吧，这个城市不存在");
        }
        return  Result.success(city1.getCid());

    }
}
