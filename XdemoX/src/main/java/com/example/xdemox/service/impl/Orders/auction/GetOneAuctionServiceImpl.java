package com.example.xdemox.service.impl.Orders.auction;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.AuctionorderMapper;
import com.example.xdemox.pojo.entity.Auctionorder;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.auction.GetOneAuctionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GetOneAuctionServiceImpl implements GetOneAuctionService{
    @Autowired
     AuctionorderMapper auctionorderMapper;

    @Override
    public Result getone(Integer id) {

        QueryWrapper<Auctionorder> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("orderid",id);
        List<Auctionorder> list = auctionorderMapper.selectList(queryWrapper);
        log.info("orderid:"+id);
        if(list.isEmpty()){
            return  Result.error("未找到该订单");
        }
        return Result.success(list);
    }
}
