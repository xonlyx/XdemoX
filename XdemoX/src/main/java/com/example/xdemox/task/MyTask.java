package com.example.xdemox.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.entity.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import java.util.List;

@Slf4j
@Component
public class MyTask {
    @Autowired
    OrdersMapper ordersMapper;


    @Scheduled(cron = "0 0/10 * * * ? ")
    public void checkOvertime() {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("masterid");
        List<Orders> ordersList = ordersMapper.selectList(queryWrapper);
        LocalDateTime now = LocalDateTime.now();
        log.info("当前：" + ordersList.size());

        //TODO: 超时未接单的订单 惩罚
        for (int i = 0, n = ordersList.size(); i < n; i++) {
            Orders orders = ordersList.get(i);
            if (orders.getMasterid() != null) {
                if (orders.getDeadline().isBefore(now)) {
                    orders.setState(5);
                    ordersMapper.updateById(orders);
                }
            }
        }



    }

}
