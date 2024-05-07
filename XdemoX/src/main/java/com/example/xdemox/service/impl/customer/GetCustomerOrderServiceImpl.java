package com.example.xdemox.service.impl.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.GetCustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomerOrderServiceImpl implements GetCustomerOrderService {
    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public Result getMyOrder(Integer id) {
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userid",id);
        List<Orders> list=ordersMapper.selectList(queryWrapper);
        if(list.isEmpty()){
            return Result.error("未找到订单");
        }
        return Result.success(list);
    }
}
