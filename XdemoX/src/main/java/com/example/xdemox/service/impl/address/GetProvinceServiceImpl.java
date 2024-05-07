package com.example.xdemox.service.impl.address;

import com.example.xdemox.mapper.ProvincialMapper;
import com.example.xdemox.pojo.entity.Provincial;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.address.GetProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProvinceServiceImpl implements GetProvinceService {

    @Autowired
    ProvincialMapper provincialMapper;
    @Override
    public Result getpronice() {
        List<Provincial> list;
        list=provincialMapper.selectList(null);

        return Result.success(list);
    }
}
