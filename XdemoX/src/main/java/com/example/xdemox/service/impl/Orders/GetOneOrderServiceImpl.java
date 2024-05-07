package com.example.xdemox.service.impl.Orders;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.xdemox.mapper.*;
import com.example.xdemox.pojo.entity.City;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.vo.OrdersVo;
import com.example.xdemox.pojo.entity.Provincial;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.Orders.GetOneOrderService;
import com.example.xdemox.utils.MyLockUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class GetOneOrderServiceImpl implements GetOneOrderService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    StateMapper stateMapper;
    @Autowired
    KindMapper kindMapper;
    @Autowired
    ProvincialMapper provincialMapper;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    MyLockUtils myLockUtils;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Transactional
    @Override
    public Result getone(Integer id) {
        log.info("  ==" + id);
        String json = stringRedisTemplate.opsForValue().get("orders:" + id);
        //log.info("  ==" + json);
        if (json != null && !json.equals("")) {
            OrdersVo ordersVo = JSONObject.parseObject(json, OrdersVo.class);
            return Result.success(ordersVo);
        }

        if (json!= null) {
            return Result.error("订单不存在");
        }

        if (!myLockUtils.trylock("orderslock:" + id)) {
            return Result.error("系统繁忙，请稍后再试");
        }
        return getResult(id);
    }

    private Result getResult(Integer id) {
        try {
            Orders orders = ordersMapper.selectById(id);
            if (orders == null) {
                stringRedisTemplate.opsForValue().set("orders:" + id, "", 60, TimeUnit.MINUTES);
                return Result.error("订单不存在");
            }

            Integer idx = orders.getId();
            Integer masterid = orders.getMasterid();

            String comment = orders.getComment();
            LocalDateTime deadline = orders.getDeadline();
            LocalDateTime createtime = orders.getCreatetime();
            LocalDateTime finishtime = orders.getFinishtime();
            LocalDateTime updatetime = orders.getUpdatetime();
            Integer userid = orders.getUserid();
            Integer scoreplus10 = orders.getScoreplus10();
            String photo = orders.getPhoto();
            Integer kind = orders.getKindname();
            Integer state = orders.getState();
            Integer province = orders.getProvince();
            Integer city = orders.getCity();
            String address = orders.getAddress();
            QueryWrapper<City> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("pid", province).eq("cid", city);
            City city1 = cityMapper.selectOne(queryWrapper);
            String cstring = city1.getCity();
            QueryWrapper<Provincial> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("pid", province);
            Provincial provincial = provincialMapper.selectOne(queryWrapper1);
            String pstring = provincial.getProvince();
            String kindstring = kindMapper.selectById(kind).getKindname();
            String statestring = stateMapper.selectById(state).getState();
            //String stringorders= JSONObject.toJSONString(orders);
            OrdersVo ordersVo = new OrdersVo(idx, masterid, userid, createtime, updatetime, finishtime, deadline, photo, kindstring, statestring, scoreplus10, comment, pstring, cstring, address);
            stringRedisTemplate.opsForValue().set("orders:" + id, JSONObject.toJSONString(ordersVo));
            return Result.success(ordersVo);
        } finally {
            myLockUtils.unlock("orderslock:" + id);
        }
    }
}
