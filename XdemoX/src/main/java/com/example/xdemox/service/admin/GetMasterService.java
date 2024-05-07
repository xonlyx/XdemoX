package com.example.xdemox.service.admin;

import com.example.xdemox.pojo.entity.PageResult;
import com.example.xdemox.pojo.entity.Result;

public interface GetMasterService {
    public PageResult getMaster(int page , int size);
}
