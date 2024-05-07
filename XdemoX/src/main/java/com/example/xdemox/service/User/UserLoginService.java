package com.example.xdemox.service.User;

import com.example.xdemox.pojo.entity.Result;

public interface UserLoginService {
    public Result getToken(String telephone , String password);

}
