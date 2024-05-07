package com.example.xdemox.service.User;

import com.example.xdemox.pojo.entity.Result;

public interface UserRegsiterService {
    public Result register(String telephone
                            ,String password
                           , String username
                           , Integer skill1
                           ,Integer skill2
                           );

}
