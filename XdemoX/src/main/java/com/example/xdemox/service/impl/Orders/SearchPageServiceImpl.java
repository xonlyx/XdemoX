package com.example.xdemox.service.impl.Orders;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.PageResult;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.SearchPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SearchPageServiceImpl implements SearchPageService {
    @Autowired
    OrdersMapper ordersMapper;
    @Override
    public PageResult search(Integer kind, Integer page, Integer size, Integer province, Integer city, Integer moneyPlus10) {
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        Page<Orders> page1 = new Page<>(page, size);
        queryWrapper.ne("kindname",6)
                .eq(province!=0,"province",province)
                .eq(city!=0,"city",city)
                .ge(moneyPlus10!=0,"moneyplus10",moneyPlus10);

        ordersMapper.selectPage(page1, queryWrapper);
        List<Orders> records = page1.getRecords();
        Long total= (long) records.size();
        return new PageResult(total,records) ;

    }
}
