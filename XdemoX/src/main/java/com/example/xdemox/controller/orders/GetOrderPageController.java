package com.example.xdemox.controller.orders;

import com.example.xdemox.pojo.dto.PageQueryDTO;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.GetOrderPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOrderPageController {
    @Autowired
    private GetOrderPageService getOrderPageService;

    @GetMapping("/api/order/page")
    public Result getOrderPage(PageQueryDTO pageQueryDTO) {
        return Result.success(getOrderPageService.getOrderPage(pageQueryDTO));
    }

}
