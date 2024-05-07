package com.example.xdemox.service.impl.Orders;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.pojo.dto.PageQueryDTO;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.PageResult;
import com.example.xdemox.service.Orders.GetOrderPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrderPageServiceImpl implements GetOrderPageService {
    @Autowired
    OrdersMapper ordersMapper;
    @Override
    public PageResult getOrderPage(PageQueryDTO pageQueryDTO) {
        Integer page = pageQueryDTO.getPage();
        Integer size = pageQueryDTO.getSize();
        Page<Orders> page1 = new Page<>(page, size);
        ordersMapper.selectPage(page1, null);
        List<Orders> records = page1.getRecords();
        Long total= (long) records.size();
        return new PageResult(total,records) ;
    }
}
