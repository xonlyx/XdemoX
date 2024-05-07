package com.example.xdemox.controller.admin;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.admin.getMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getMessageController {

    @Autowired
    getMessage getMessage;

    @PostMapping ("/api/admin/getMessage")
    public Result getMessage(String msg, String sid){
        return getMessage.getMessage(msg, sid);
    }

}
