package com.example.xdemox.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.xdemox.mapper.UserInfoMapper;
import com.example.xdemox.pojo.entity.Msg;
import com.example.xdemox.pojo.entity.User;
import com.example.xdemox.pojo.entity.Userinfo;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@ServerEndpoint("/ws/{sid}")
@Slf4j
public class WebSocketUtils {

    @Autowired
    UserInfoMapper userInfoMapper;
    private static Map<String, Session> sessionMap=new HashMap<>();

    public boolean mapIsEmpty(){
        return sessionMap.isEmpty();
    }



    @OnOpen
    public void onOpen(Session session, @PathParam("sid")String sid){
        sessionMap.put(sid,session);
        //Msg msg =new Msg("开始链接",false,true);
        log.info("sid:"+sid);
        //sendToOne(msg,sid);
    }

    @OnMessage
    public void OnMessage(String message, @PathParam("sid")String sid){
        System.out.println(message);

    }
    @OnClose
    public void OnClose(Session session, @PathParam("sid")String sid){
        //Msg msg =new Msg("断开链接",true);
        //sendToOne(msg,sid);
        sessionMap.remove(sid);
    }


    public void sendToOne(String msg, String sid){

        Session session=sessionMap.get(sid);
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendToOne(Msg msg, String sid){
        String jsonString = JSONObject.toJSONString(msg);
        Session session=sessionMap.get(sid);
        try {
            session.getBasicRemote().sendText(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void  sendToAll(String message){
        Collection<Session> sessions=sessionMap.values();
        for(Session session:sessions){
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Userinfo> getOnlineUser(){
        List<Userinfo>  list =new ArrayList<>();

        for(String key : sessionMap.keySet()){
            log.info("key:"+key);
            if(key.contains("masterid")){
                String id = key.split("masterid")[1];

                Userinfo userinfo = userInfoMapper.selectById(id);
                list.add(userinfo);
            }
        }

        return list;
    }




}
