package com.example.xdemox.controller.admin;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.admin.GetOneMasterServer;
import com.example.xdemox.service.admin.GetOnlineMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOnlineMasterController {

    @Autowired
    GetOnlineMasterService getOnlineMasterService;

    @GetMapping("/api/admin/getonlinemaster")
    public Result getonlinemaster(){
        return getOnlineMasterService.GetOnlineMaster();
    }
}
