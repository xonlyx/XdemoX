package com.example.xdemox.service.impl.master;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.context.BaseContext;
import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.master.GetMyOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GetMyOrderServiceImpl implements GetMyOrderService {
    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public Result getMyOrder(Integer id) {

        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("masterid",id);
        List<Orders> list=ordersMapper.selectList(queryWrapper);
        if(list.isEmpty()){
            return Result.error("未找到订单");
        }
        return Result.success(list);
    }
}
