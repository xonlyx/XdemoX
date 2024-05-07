package com.example.xdemox.controller.admin;

import com.example.xdemox.mapper.UserMapper;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.admin.GetMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMasterController {
    @Autowired
    GetMasterService getMasterService;

    @GetMapping("/api/admin/master")
    public Result GetMasterController(Integer page , Integer size){

        return Result.success(getMasterService.getMaster(page , size));
    }


}
