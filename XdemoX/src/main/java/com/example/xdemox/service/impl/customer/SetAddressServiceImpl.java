package com.example.xdemox.service.impl.customer;

import com.example.xdemox.mapper.AddressMapper;
import com.example.xdemox.pojo.entity.Address;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.SetAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetAddressServiceImpl implements SetAddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public Result setaddress(String address, Integer city_id, Integer province_id, Integer user_id) {

        if (address == null || address.length() == 0) {
            return Result.error("地址不能为空");
        }
        if (city_id == null || city_id == 0) {
            return  Result.error("城市不能为空");
        }
        if (province_id == null || province_id == 0) {
            return Result.error("省份不能为空");
        }
        if (user_id == null || user_id == 0) {
            return Result.error("用户id不能为空");
        }
        Address address1 =new Address(null ,user_id,address,city_id,province_id,0);
        addressMapper.insert(address1);


        return Result.success("设置成功");
    }
}
