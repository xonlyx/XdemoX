package com.example.xdemox.controller.orders;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.GetOneOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GetOneOrderComtroller {
    @Autowired
    GetOneOrderService getOneOrderService;
    @GetMapping("/api/order")
    //@Cacheable(cacheNames = "ordersCache", key = "#id")
    public Result getone( Integer id){
        return  getOneOrderService.getone(id);
    }

}
