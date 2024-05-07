package com.example.xdemox.service.impl.Orders.auction;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.AuctionorderMapper;
import com.example.xdemox.pojo.entity.Auctionorder;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.auction.BidPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BidPriceServiceImpl implements BidPriceService {

    @Autowired
    AuctionorderMapper auctionorderMapper;
    @Override
    public Result bid(Integer orderid, Integer masterid, Integer money) {
        QueryWrapper<Auctionorder> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("orderid",orderid);
        log.info("orderid:"+orderid);
        List<Auctionorder> list = auctionorderMapper.selectList(queryWrapper);
        if(list.isEmpty()){
            return  Result.error("未找到该订单1");
        }
        Auctionorder auctionorder =new Auctionorder(null,orderid,masterid,null,null,null,null,null,money);
        auctionorderMapper.insert(auctionorder);

        return  Result.success();
    }
}
