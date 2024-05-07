package com.example.xdemox.service.customer;

import com.example.xdemox.pojo.entity.Result;

public interface SetAddressService {
    public Result setaddress(String address, Integer city_id, Integer province_id, Integer user_id);

}
