package com.example.xdemox.service.impl.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.mapper.UserInfoMapper;
import com.example.xdemox.mapper.UserMapper;
import com.example.xdemox.pojo.entity.*;
import com.example.xdemox.service.admin.GetMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetMasterServiceImpl implements GetMasterService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public PageResult getMaster(int page , int size)  {
        Page<Userinfo> page1 = new Page<>(page, size);

        Page<Userinfo> ipage = userInfoMapper.selectPage(page1, null);
        List<Userinfo> records = page1.getRecords();
        Long total= (long) records.size();
        return new PageResult(total,records) ;

    }
}
