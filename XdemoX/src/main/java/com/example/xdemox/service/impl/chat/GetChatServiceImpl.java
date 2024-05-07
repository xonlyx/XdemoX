package com.example.xdemox.service.impl.chat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.ChathistoryMapper;
import com.example.xdemox.pojo.entity.Chathistory;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.chat.GetChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetChatServiceImpl implements GetChatService {
    @Autowired
    ChathistoryMapper chathistoryMapper;

    @Override
    public Result getChat(String masterid) {
        List<Chathistory> chathistoryList ;
        QueryWrapper<Chathistory> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Chathistory> queryWrapper1 = new QueryWrapper<>();
        queryWrapper.eq("fromid",masterid).eq("toid","-1");
        queryWrapper1.eq("fromid","-1").eq("toid",masterid);
        chathistoryList = chathistoryMapper.selectList(queryWrapper);
        chathistoryList.addAll(chathistoryMapper.selectList(queryWrapper1));
        chathistoryList.sort((o1, o2) -> o1.getCreatetime().compareTo(o2.getCreatetime()));

        return Result.success(chathistoryList);
    }
}
