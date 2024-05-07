package com.example.xdemox.service.impl.User;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.UserMapper;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.User;
import com.example.xdemox.service.User.UserForgetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserForgetPasswordServiceImpl implements UserForgetPasswordService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Result forget(String telephone ,String password) {
        User user=null;
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("telephone",telephone);
        user=userMapper.selectOne(queryWrapper);
        if(user==null){
            return Result.error("手机号未注册");
        }
        password= DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(password);
        userMapper.updateById(user);
        return Result.success();
    }
}
