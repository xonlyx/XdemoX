package com.example.xdemox.controller.orders;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.EnableOrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnableOrderPageController {

    @Autowired
    EnableOrderPage enableOrderPageService;

    @GetMapping("/api/enableorder/page")
    public Result getpage(Integer page, Integer size) {
       return Result.success(enableOrderPageService.getpage(page, size));
    }

}
