package com.example.xdemox.service.impl.Orders.auction;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.AuctionorderMapper;
import com.example.xdemox.pojo.entity.Auctionorder;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.auction.GetDistinctOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDistinctOrder implements GetDistinctOrderService {

    @Autowired
    AuctionorderMapper auctionorderMapper;

    @Override
    public Result getDistinctOrder() {
        QueryWrapper<Auctionorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("DISTINCT orderid ,id,userid,masterid ,moneyplus10,createtime")
                .eq("complete",0).isNull("masterid");
        List<Auctionorder> list = auctionorderMapper.selectList(queryWrapper);
        //Integer size = list.size();

        return Result.success(list);
    }
}
