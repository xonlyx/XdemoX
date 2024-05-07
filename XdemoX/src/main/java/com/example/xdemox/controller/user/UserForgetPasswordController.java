package com.example.xdemox.controller.user;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.User;
import com.example.xdemox.service.User.UserForgetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserForgetPasswordController {
@Autowired
    UserForgetPasswordService userForgetPasswordService;

    @PostMapping("/api/forget")
    public Result forget( User user){
        String telephone = user.getTelephone();
        String password = user.getPassword();
        return userForgetPasswordService.forget(telephone,password);
    }

}
