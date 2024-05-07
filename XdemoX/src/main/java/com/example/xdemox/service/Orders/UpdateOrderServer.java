package com.example.xdemox.service.Orders;

import com.example.xdemox.pojo.entity.Result;

public interface UpdateOrderServer {

    //更新订单状态
    Result updateOrderStatus(Integer orderId ,Integer userid ,Integer kindname ,Integer moneyplus10 ,Integer province ,Integer city ,String address);
}
