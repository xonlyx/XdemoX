package com.example.xdemox.controller.chat;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.chat.GetChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetChatController {

    @Autowired
    GetChatService getChatService;

    @GetMapping("/api/getchat")
    public Result getChat(String masterid){
        return getChatService.getChat(masterid);
    }

}
