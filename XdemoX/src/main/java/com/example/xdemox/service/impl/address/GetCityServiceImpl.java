package com.example.xdemox.service.impl.address;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.CityMapper;
import com.example.xdemox.pojo.dto.CityDto;
import com.example.xdemox.pojo.entity.City;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.address.GetCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GetCityServiceImpl implements GetCityService {
    @Autowired
    CityMapper cityMapper;

    @Override
    public Result getcity(Integer id) {

        QueryWrapper<City> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("pid",id);
        List<City> city=cityMapper.selectList(queryWrapper);

        return Result.success(city);
    }
}
