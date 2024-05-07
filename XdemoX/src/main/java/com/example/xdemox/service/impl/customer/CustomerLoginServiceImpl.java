package com.example.xdemox.service.impl.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.CustomerMapper;
import com.example.xdemox.mapper.UserMapper;
import com.example.xdemox.pojo.entity.Customer;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.CustomerLoginService;
import com.example.xdemox.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service

public class CustomerLoginServiceImpl implements CustomerLoginService {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    TokenUtils tokenUtils;
    @Override
    public Result login(String telephone, String password) {
        password= DigestUtils.md5DigestAsHex(password.getBytes());
        Customer customer=new Customer();
        QueryWrapper queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("telephone",telephone);
        customer=customerMapper.selectOne(queryWrapper);
        if(customer==null){
            return Result.error("用户不存在");
        }
        if(!password.equals(customer.getPassword())){
            return Result.error("密码错误");
        }
        String token=tokenUtils.createJWtoken(customer.getId());
        Map<String,String> map =new HashMap<>();
        map.put("token",token);
        map.put("userId",String.valueOf(customer.getId()));
        return Result.success( map);
    }
}
