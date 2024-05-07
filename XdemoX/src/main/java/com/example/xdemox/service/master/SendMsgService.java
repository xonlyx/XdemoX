package com.example.xdemox.service.master;


import com.example.xdemox.pojo.entity.Result;

public interface SendMsgService {
    public Result SendMsg(String msg,String masterid);
}
