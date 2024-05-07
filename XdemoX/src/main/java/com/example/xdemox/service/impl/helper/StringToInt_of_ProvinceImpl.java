package com.example.xdemox.service.impl.helper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.ProvincialMapper;
import com.example.xdemox.pojo.entity.Provincial;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.helper.StringToInt_of_Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringToInt_of_ProvinceImpl implements StringToInt_of_Province {

    @Autowired
    ProvincialMapper provincialMapper;
    @Override
    public Result StringToInt_of_Province(String province) {
        QueryWrapper<Provincial> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("province",province);
        Provincial provincial = provincialMapper.selectOne(queryWrapper);
        if (provincial==null){
            return Result.error("打错字了吧，这个省份不存在");
        }
        return  Result.success(provincial.getPid());
    }
}
