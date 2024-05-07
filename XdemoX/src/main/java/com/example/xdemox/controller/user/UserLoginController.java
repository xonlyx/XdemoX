package com.example.xdemox.controller.user;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.User;
import com.example.xdemox.service.User.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class UserLoginController {

    @Autowired
    UserLoginService userLoginService;

    @PostMapping("/api/login")
    public Result login(  User user){
        log.info("用户登录");
        String telephone = user.getTelephone();
        String password = user.getPassword();
        return userLoginService.getToken(telephone,password);

    }


}
