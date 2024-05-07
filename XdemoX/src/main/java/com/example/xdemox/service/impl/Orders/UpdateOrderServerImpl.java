package com.example.xdemox.service.impl.Orders;

import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.UpdateOrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderServerImpl implements UpdateOrderServer {
    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Override
    public Result updateOrderStatus(Integer orderId, Integer userid, Integer kindname, Integer moneyplus10, Integer province, Integer city, String address) {

        Orders orders = ordersMapper.selectById(orderId);

        if (orders == null) {
            return Result.error("订单不存在");
        }
        if (orders.getUserid() != userid) {
            return Result.error("用户不匹配");
        }

        stringRedisTemplate.delete("orders:" + orderId);

        kindname = kindname == null ? orders.getKindname() : kindname;
        moneyplus10 = moneyplus10 == null ? orders.getMoneyplus10() : moneyplus10;
        province = province == null ? orders.getProvince() : province;
        city = city == null ? orders.getCity() : city;
        address = address == null ? orders.getAddress() : address;
        orders.setKindname(kindname);
        orders.setMoneyplus10(moneyplus10);
        orders.setProvince(province);
        orders.setCity(city);
        orders.setAddress(address);
        ordersMapper.updateById(orders);
        return Result.success("更新成功");


    }
}
