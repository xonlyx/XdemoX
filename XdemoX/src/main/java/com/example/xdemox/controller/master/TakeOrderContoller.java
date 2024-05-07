package com.example.xdemox.controller.master;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.master.TakeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TakeOrderContoller {

    @Autowired
    TakeOrderService takeOrderService;

    @CacheEvict(cacheNames = "ordersCache", key = "#orderId")
    @PostMapping("/api/master/takeorder")
    public Result takeorder(Integer orderId,Integer masterid){
        return takeOrderService.takeOrder(orderId,masterid);
    }
}
