package com.example.xdemox.service.admin;

import com.example.xdemox.pojo.entity.Result;

public interface LoginService {
    public Result  getToken(String username, String password);
}
