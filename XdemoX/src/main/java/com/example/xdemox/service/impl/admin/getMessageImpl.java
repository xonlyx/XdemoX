package com.example.xdemox.service.impl.admin;

import com.example.xdemox.mapper.ChathistoryMapper;
import com.example.xdemox.pojo.entity.Chathistory;
import com.example.xdemox.pojo.entity.Msg;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.admin.getMessage;
import com.example.xdemox.utils.WebSocketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class getMessageImpl implements getMessage {

    @Autowired
    WebSocketUtils webSocketUtils;
    @Autowired
    ChathistoryMapper chathistoryMapper;
    @Override
    public Result getMessage(String msg, String sid) {

        Msg currentmsg = new Msg(msg, true,false);
        String currentsid = "masterid" + sid;
        webSocketUtils.sendToOne(currentmsg, currentsid);

        //TODO: 开一个线程，保存到数据库

        Chathistory chathistory = new Chathistory(null,-1,Integer.valueOf(sid),msg, LocalDateTime.now());
        chathistoryMapper.insert(chathistory);


        return Result.success("发送成功");
    }
}
