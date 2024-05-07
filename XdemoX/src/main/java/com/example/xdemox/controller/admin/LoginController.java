package com.example.xdemox.controller.admin;


import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.admin.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/api/admin/login")
    public Result login(String  username,String password){
        return loginService.getToken(username,password);
    }


}
