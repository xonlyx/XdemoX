package com.example.xdemox.controller.orders;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.UpdateOrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateOrderServerController {
    @Autowired
    UpdateOrderServer updateOrderServer;

    @PutMapping("/api/orders")
    public Result updateOrderStatus(Integer orderId , Integer userid , Integer kindname , Integer moneyplus10 , Integer province , Integer city , String address){
        return updateOrderServer.updateOrderStatus(orderId,userid,kindname,moneyplus10,province,city,address);
    }
}
