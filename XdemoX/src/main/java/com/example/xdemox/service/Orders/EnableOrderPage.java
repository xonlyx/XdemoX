package com.example.xdemox.service.Orders;

import com.example.xdemox.pojo.entity.PageResult;
import com.example.xdemox.pojo.entity.Result;

public interface EnableOrderPage {
    public PageResult getpage(Integer page, Integer size);
}
