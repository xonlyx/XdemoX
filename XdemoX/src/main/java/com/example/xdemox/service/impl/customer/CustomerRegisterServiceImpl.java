package com.example.xdemox.service.impl.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.CustomerMapper;
import com.example.xdemox.pojo.entity.Customer;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.CustomerRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class  CustomerRegisterServiceImpl implements CustomerRegisterService {
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public Result register(Integer telephone, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("telephone", telephone);
        Customer customer = null;
        customer=customerMapper.selectOne(queryWrapper);

        if(customer != null){
            return Result.error("用户已存在");
        }
        customer = new Customer(null, telephone, password);

        customerMapper.insert(customer);
        return Result.success("注册成功");

    }
}
