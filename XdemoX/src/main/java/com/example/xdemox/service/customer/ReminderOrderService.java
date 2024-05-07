package com.example.xdemox.service.customer;

import com.example.xdemox.pojo.entity.Result;

public interface ReminderOrderService {

	public Result sendReminder(Integer orderId) ;
}
