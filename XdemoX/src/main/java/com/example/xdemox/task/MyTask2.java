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
public class MyTask2 {
    @Autowired
    OrdersMapper ordersMapper;

    @Scheduled(cron = "0 0/10 * * * ? ")
    public void checkOvertime1() {
        QueryWrapper<Orders> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("state", 6);
        LocalDateTime now = LocalDateTime.now();
        List<Orders> ordersList1 = ordersMapper.selectList(queryWrapper1);
        log.info("当前1：" + ordersList1.size());
        for (int i = 0, n = ordersList1.size(); i < n; i++) {
            Orders orders = ordersList1.get(i);
            if (orders.getDeadline().isBefore(now)) {
                orders.setState(11);
                ordersMapper.updateById(orders);
            }

        }
    }

}
