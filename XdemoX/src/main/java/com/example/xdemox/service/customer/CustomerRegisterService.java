package com.example.xdemox.service.customer;

import com.example.xdemox.pojo.entity.Result;

public interface CustomerRegisterService {
    public Result register(Integer telephone, String password);
}
