package com.example.xdemox.service.impl.master;

import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.mapper.UserInfoMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.Userinfo;
import com.example.xdemox.service.master.FinishOrderMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class FinishOrderMasterServiceImpl implements FinishOrderMasterService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public Result finishOrder(Integer orderId) {
        log.info("确认完成订单"+orderId);
        Orders orders = ordersMapper.selectById(orderId);

        if (orders == null) {
            return Result.error("订单不存在");
        }
        if (orders.getState() != 9 && orders.getState() != 12) {
            return Result.error("订单状态不正确");
        }
        if(orders.getState() == 9){
            orders.setState(13);
            ordersMapper.updateById(orders);
            return Result.success("确认完成");

        }else if(orders.getState() == 12){
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
