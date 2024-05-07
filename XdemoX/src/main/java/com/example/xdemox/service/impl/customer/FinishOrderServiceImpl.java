package com.example.xdemox.service.impl.customer;

import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.mapper.UserInfoMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.Userinfo;
import com.example.xdemox.service.customer.FinishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FinishOrderServiceImpl implements FinishOrderService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public Result finishOrder(String orderId) {
        Orders orders = ordersMapper.selectById(orderId);
        if (orders == null) {
            return Result.error("订单不存在");
        }
        if (orders.getState() != 9 && orders.getState() != 13) {
            return Result.error("订单状态不正确");
        }
        if(orders.getState() == 9){
            orders.setState(12);
            ordersMapper.updateById(orders);
            return Result.success("确认完成");

        }else if(orders.getState() == 13){
            orders.setState(1);
            LocalDateTime now = LocalDateTime.now();
            orders.setFinishtime(now);
            Integer masterid = orders.getMasterid();
            ordersMapper.updateById(orders);
            Userinfo userinfo = userInfoMapper.selectById(masterid);
            userinfo.setOrderamount(userinfo.getOrderamount()+1);
            userinfo.setMoneyplus100(userinfo.getMoneyplus100()+orders.getMoneyplus10());
            userInfoMapper.updateById(userinfo);
            return Result.success("确认完成");
        }
        return Result.error("订单状态不正确");
    }
}
