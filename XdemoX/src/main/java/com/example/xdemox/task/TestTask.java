package com.example.xdemox.task;

import com.example.xdemox.service.customer.ReminderOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestTask {
    @Autowired
    ReminderOrderService reminderOrderService;
    //@Scheduled(cron = "0/5 * * * * ? ")
    public  void tet(){

    }

}
