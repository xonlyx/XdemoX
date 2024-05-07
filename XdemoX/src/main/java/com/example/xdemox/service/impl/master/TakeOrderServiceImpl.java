package com.example.xdemox.service.impl.master;

import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.master.TakeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakeOrderServiceImpl implements TakeOrderService {
    @Autowired
    OrdersMapper ordersMapper;
    @Override
    public Result takeOrder(Integer orderId, Integer masterid) {
        Orders orders=ordersMapper.selectById(orderId);

        if(orders==null){
            return Result.error("没有该订单");
        }
        if(orders.getState()==9){
            return Result.error("该订单已被接单");
        }

        orders.setState(9);
        orders.setMasterid(masterid);
        ordersMapper.updateById(orders);
        return Result.success("师傅成功接单");
    }
}
