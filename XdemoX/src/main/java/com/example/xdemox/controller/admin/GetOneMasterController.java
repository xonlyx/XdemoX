package com.example.xdemox.controller.admin;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.admin.GetOneMasterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOneMasterController {
    @Autowired
    GetOneMasterServer getOneMasterServer;

    @PostMapping("/api/master/get")
    public Result getone(Integer id){
        return getOneMasterServer.getone(id);
    }
}
