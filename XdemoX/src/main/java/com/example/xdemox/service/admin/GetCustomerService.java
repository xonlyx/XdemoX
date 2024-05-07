package com.example.xdemox.service.admin;

import com.example.xdemox.pojo.entity.PageResult;
import com.example.xdemox.pojo.entity.Result;

public interface GetCustomerService {


    PageResult getCustomer(int size, int page);
}
