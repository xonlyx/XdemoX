package com.example.xdemox.controller.orders;

import com.example.xdemox.pojo.dto.PageQueryDTO;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.SearchPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchPageController {

    @Autowired
    SearchPageService searchPageService;

    @PostMapping("/api/order/search")
    public Result search(Integer kind , Integer page, Integer size, Integer province , Integer city , Integer moneyPlus10) {

        return Result.success(searchPageService.search(kind,page,size,province,city,moneyPlus10));
    }

}
