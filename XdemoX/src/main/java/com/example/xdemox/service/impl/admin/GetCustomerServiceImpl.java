package com.example.xdemox.service.impl.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.xdemox.mapper.CustomerMapper;
import com.example.xdemox.pojo.entity.Customer;
import com.example.xdemox.pojo.entity.PageResult;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.pojo.entity.Userinfo;
import com.example.xdemox.service.admin.GetCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomerServiceImpl implements GetCustomerService {


    @Autowired
    CustomerMapper customerMapper;
    @Override
    public PageResult getCustomer(int size, int page) {
        Page<Customer> page1 = new Page<>(page, size);

        Page<Customer> ipage = customerMapper.selectPage(page1, null);
        List<Customer> records = page1.getRecords();
        Long total= (long) records.size();
        return new PageResult(total,records) ;
    }
}
