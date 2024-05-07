package com.example.xdemox.service.impl.customer;

import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.mapper.UserInfoMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.Userinfo;
import com.example.xdemox.service.customer.EvaluteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluteOrderServiceImpl implements EvaluteOrderService {

    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    public Result evaluteOrder(String orderId, String comment, Integer socre) {
        Orders orders = ordersMapper.selectById(orderId);
        if (orders == null) {
            return Result.error("订单不存在");
        }
        if (orders.getState() !=1) {
            return Result.error("订单状态不正确");
        }
        orders.setComment(comment);
        orders.setScoreplus10(socre);
        Integer masterid = orders.getMasterid();
        Userinfo userinfo = userInfoMapper.selectById(masterid);
        Integer orderamount = userinfo.getOrderamount();
        Integer scoreplus10 = userinfo.getScoreplus10();
        Integer nowscore = ((orderamount-1)*scoreplus10+socre)/orderamount;
        userinfo.setScoreplus10(nowscore);
        ordersMapper.updateById(orders);
        userInfoMapper.updateById(userinfo);

        return Result.success("评价成功");
    }
}
