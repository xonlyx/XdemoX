package com.example.xdemox.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    public Result classifyOrder(Integer masterid,Integer userid);

}
