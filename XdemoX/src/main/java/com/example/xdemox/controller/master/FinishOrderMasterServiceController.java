package com.example.xdemox.controller.master;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.master.FinishOrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinishOrderMasterServiceController {

    @Autowired
    FinishOrderMasterService finishOrderService;

    @PutMapping("/api/master/finishOrder")
    public Result finishOrder(Integer orderId){

        return finishOrderService.finishOrder(orderId);
    }

}
