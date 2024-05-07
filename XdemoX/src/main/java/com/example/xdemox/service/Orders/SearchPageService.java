package com.example.xdemox.service.Orders;

import com.example.xdemox.pojo.entity.PageResult;
import com.example.xdemox.pojo.entity.Result;

public interface SearchPageService {
    public PageResult search(Integer kind , Integer page, Integer size, Integer province , Integer city , Integer moneyPlus10);
}
