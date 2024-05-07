package com.example.xdemox.controller.master;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.master.SendMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMsgController {

    @Autowired
    SendMsgService sendMsgService;

    @PostMapping("/api/master/sendmsg")
    public Result SendMsg(String msg,String masterid){
        return sendMsgService.SendMsg(msg,masterid);
    }

}
