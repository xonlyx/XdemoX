package com.example.xdemox.service.impl.master;

import com.example.xdemox.mapper.ChathistoryMapper;
import com.example.xdemox.pojo.entity.Chathistory;
import com.example.xdemox.pojo.entity.Msg;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.master.SendMsgService;
import com.example.xdemox.utils.WebSocketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SendMsgServiceImpl implements SendMsgService {
    @Autowired
    WebSocketUtils webSocketUtils;
    @Autowired
    ChathistoryMapper chathistoryMapper;

    @Override
    public Result SendMsg(String msg, String masterid) {
        Msg currentmsg = new Msg(msg, true, false);
        String currentsid = "admin";
        webSocketUtils.sendToOne(currentmsg, currentsid);
//TODO:  开一个线程，保存到数据库
        Chathistory chathistory = new Chathistory(null, Integer.valueOf(masterid), -1, msg, LocalDateTime.now());
        chathistoryMapper.insert(chathistory);

        return Result.success("发送成功");
    }
}
