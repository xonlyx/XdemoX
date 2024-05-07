package com.example.xdemox.service.impl.admin;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.Userinfo;
import com.example.xdemox.service.admin.GetOnlineMasterService;
import com.example.xdemox.utils.WebSocketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOnlineMasterServiceImpl implements GetOnlineMasterService {

    @Autowired
    WebSocketUtils webSocketUtils;
    @Override
    public Result GetOnlineMaster() {
        List<Userinfo> list = webSocketUtils.getOnlineUser();
        return Result.success(list);
    }
}
