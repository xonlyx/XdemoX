package com.example.xdemox.service.impl.Orders;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.PageResult;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.EnableOrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnableOrderPageImpl implements EnableOrderPage {
    @Autowired
    OrdersMapper ordersMapper;
    @Override
    public PageResult getpage(Integer page, Integer size) {

        Page<Orders> page1 = new Page<>(page, size);
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("state", 6);
        ordersMapper.selectPage(page1, wrapper);
        List<Orders> records = page1.getRecords();
        Long total= (long) records.size();
        return new PageResult(total,records) ;
    }
}
