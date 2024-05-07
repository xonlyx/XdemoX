package com.example.xdemox.service.customer;

import com.example.xdemox.pojo.entity.Result;

public interface CustomerLoginService {
    public Result login(String telephone, String password);

}
