package com.example.xdemox.controller.master;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.master.GetMyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMyOrderController {

    @Autowired
    GetMyOrderService getMyOrderService;
    @PostMapping("/api/master/order")
    public Result getMyOrder(Integer id) {
        return getMyOrderService.getMyOrder(id);
    }
}
