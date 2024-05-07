package com.example.xdemox.service.impl.User;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.UserMapper;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.User;
import com.example.xdemox.service.User.UserLoginService;
import com.example.xdemox.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TokenUtils tokenUtils;
    @Override
    public Result getToken(String telephone, String password) {
        log.info("用户登录");
        log.info(telephone+" "+password);
        User user;
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("telephone",telephone);
        user=userMapper.selectOne(queryWrapper);

        password= DigestUtils.md5DigestAsHex(password.getBytes());
        log.info(password);
        log.info(user.getPassword());
        if(!password.equals(user.getPassword())) {
            return Result.error("用户名或密码错误");
        }

        String token=tokenUtils.createJWtoken(user.getId());


        return Result.success(token);
    }
}
