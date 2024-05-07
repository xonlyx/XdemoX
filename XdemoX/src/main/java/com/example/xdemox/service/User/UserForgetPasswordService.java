package com.example.xdemox.service.User;

import com.example.xdemox.pojo.entity.Result;

public interface UserForgetPasswordService {
    public Result forget(String telephone ,String password);
}
