package com.example.xdemox.controller.user;

import com.example.xdemox.pojo.dto.UserRegisterDTO;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.User.UserRegsiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegsiterController {
    @Autowired
    UserRegsiterService userRegsiterService;

    @PostMapping("/api/register")
    public Result register( UserRegisterDTO userRegisterDTO) {
        String password = userRegisterDTO.getPassword();
        String telephone = userRegisterDTO.getTelephone();
        Integer skill1 = userRegisterDTO.getSkill1();
        Integer skill2 = userRegisterDTO.getSkill2();
        String username = userRegisterDTO.getUsername();
        String msg=null;

        // 校验 电话号码 密码 长度

        if(password.length()<6||password.length()>16){
            msg = "密码长度为6-16位";
        }else if(telephone.length()!=11){
            msg= "手机号码格式不正确";
        }else if(skill1 ==null||skill2==null){
            msg = "技能至少选择一项";
        }else if(username.isEmpty() || username == null){
            msg = "用户名不能为空";
        }

        if(msg!=null){
            return  Result.error(msg);
        }
        return  userRegsiterService.register(telephone,password,username,skill1,skill2);
    }


}
