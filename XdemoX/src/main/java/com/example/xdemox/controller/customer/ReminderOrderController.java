package com.example.xdemox.controller.customer;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.ReminderOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReminderOrderController {
    @Autowired
    ReminderOrderService reminderOrderService;

    @PostMapping("/api/reminder")
    public Result reminder(Integer id) {

        return reminderOrderService.sendReminder(id);
    }

}
