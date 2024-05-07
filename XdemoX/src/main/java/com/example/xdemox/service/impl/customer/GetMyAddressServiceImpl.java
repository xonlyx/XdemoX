package com.example.xdemox.service.impl.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.AddressMapper;
import com.example.xdemox.pojo.entity.Address;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.GetMyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMyAddressServiceImpl implements GetMyAddressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public Result getMyAddress(Integer customerid) {

        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customerid", customerid).orderByAsc("weight");
        List<Address> addressList = addressMapper.selectList(queryWrapper);

        return Result.success(addressList);

    }
}
