package com.example.xdemox.service.Orders;

import com.example.xdemox.pojo.dto.PageQueryDTO;
import com.example.xdemox.pojo.entity.PageResult;

public interface GetOrderPageService {
    public PageResult getOrderPage(PageQueryDTO pageQueryDTO);
}
