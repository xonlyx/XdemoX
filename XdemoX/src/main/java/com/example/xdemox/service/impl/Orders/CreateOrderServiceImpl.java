package com.example.xdemox.service.impl.Orders;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.AddressMapper;
import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.entity.Address;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.CreateOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@Slf4j
@Service
public class CreateOrderServiceImpl implements CreateOrderService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    AddressMapper addressMapper;

    @Override
    public Result create(Integer userid, LocalDateTime deadline, Integer kind, String photo, Integer province, Integer city, String address, Integer moneyplus10, LocalDateTime now) {
        Orders orders = new Orders(null, null, userid, now, now, null, deadline, photo, kind, null, null, null, province, city, address, moneyplus10);

        QueryWrapper<Address> queryWrapperAddress = new QueryWrapper<>();
        queryWrapperAddress.eq("customerid", userid).eq("address", address).eq("city", city).eq("province", province);
        Address address1 = addressMapper.selectOne(queryWrapperAddress);
        if (address1 == null) {
            return Result.error("地址不存在");
        }
        Integer weight = address1.getWeight();
        address1.setWeight(weight + 1);
        addressMapper.updateById(address1);

        ordersMapper.insert(orders);

        log.info("订单创建成功"+ orders.getId());
        Integer id = orders.getId();
        if(stringRedisTemplate.opsForValue().get("order_" + id) == null){
            return Result.success("订单创建成功");
        }
        if (stringRedisTemplate.opsForValue().get("order_" + id).equals("")) {
            stringRedisTemplate.delete("order_" + id);
        }

        return Result.success("订单创建成功");
    }
}
