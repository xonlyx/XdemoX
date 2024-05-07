package com.example.xdemox.service.impl.User;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.UserInfoMapper;
import com.example.xdemox.mapper.UserMapper;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.User;
import com.example.xdemox.pojo.entity.Userinfo;
import com.example.xdemox.service.User.UserRegsiterService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserRegsiterServiceImpl implements UserRegsiterService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public Result register(String telephone, String password, String username, Integer skill1, Integer skill2) {
        User user=null;
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("telephone",telephone);
        user=userMapper.selectOne(queryWrapper);

        ;
        if(user!=null){
            return Result.error("已经注册");
        }

        password= DigestUtils.md5DigestAsHex(password.getBytes());
        user=new User(null,telephone,password);

        userMapper.insert(user);
        LocalDateTime now=LocalDateTime.now();
        Userinfo userInfo=new Userinfo(null,username,telephone,now,now,null,null,null,null,skill1,skill2);
        userInfoMapper.insert(userInfo);

        return Result.success("注册成功");
    }
}
