package com.example.xdemox.service.impl.Orders.auction;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.AuctionorderMapper;
import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.entity.Auctionorder;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.auction.CreateAuctionOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
@Slf4j
public class CreateAuctionOrderServiceImpl implements CreateAuctionOrderService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    AuctionorderMapper auctionorderMapper;

    @Transactional
    @Override
    public Result create(Integer userid,LocalDateTime time,Integer kind,String url,Integer province,Integer city,String address,Integer money,LocalDateTime realnow) {
        Orders orders =new Orders(null, null, userid, realnow, realnow, null, time, url, kind, 10, null, null, province, city, address, money);
        log.info("userid:"+userid+"time:"+time);
        ordersMapper.insert(orders);
        orders.setState(10);
        ordersMapper.updateById(orders);

        Auctionorder auctionorder=new Auctionorder(null, orders.getId(), null,userid,realnow,realnow,null,0,money);
        auctionorderMapper.insert(auctionorder);
        return  Result.success();
    }
}
