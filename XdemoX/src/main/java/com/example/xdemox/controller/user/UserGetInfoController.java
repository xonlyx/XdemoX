package com.example.xdemox.controller.user;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.User.UserGetInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserGetInfoController {

    @Autowired
    UserGetInfoService userGetInfoService;
    @GetMapping("/api/user")
    public Result getinfo(){

        return  userGetInfoService.getinfo();
    }

}
