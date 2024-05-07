package com.example.xdemox.service.impl.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.AdminMapper;
import com.example.xdemox.pojo.entity.Admin;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.admin.LoginService;
import com.example.xdemox.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    TokenUtils tokenUtils;

    @Override
    public Result getToken(String username, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", password);
        Admin admin = adminMapper.selectOne(wrapper);
        if (admin == null) {
            return Result.error("用户名或密码错误");
        }
        String token = tokenUtils.createJWtoken(admin.getId());
        return Result.success(token);
    }
}
