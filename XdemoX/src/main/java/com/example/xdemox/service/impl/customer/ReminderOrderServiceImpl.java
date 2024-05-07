package com.example.xdemox.service.impl.customer;

import com.example.xdemox.mapper.OrdersMapper;
import com.example.xdemox.mapper.UserInfoMapper;
import com.example.xdemox.pojo.entity.Msg;
import com.example.xdemox.pojo.entity.Orders;
import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.customer.ReminderOrderService;
import com.example.xdemox.utils.WebSocketUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReminderOrderServiceImpl implements ReminderOrderService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    WebSocketUtils webSocketUtils;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    private JavaMailSenderImpl mailSender;
    @Override
    public Result sendReminder(Integer orderId) {
        Orders order=ordersMapper.selectById(orderId);
        if(order.getState()!=9){
            return Result.error("订单状态错误");
        }
        Integer masterid;
        masterid=order.getMasterid();
        String sid="masterid"+masterid.toString();
        log.info("sid:"+sid);
        Msg msg =new Msg("订单号为"+orderId.toString()+"的顾客正在催单",false,false);

        String email = userInfoMapper.selectById(masterid).getTelephone()+"@qq.com";
        log.info("email:"+email);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("925192866@qq.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("催单");
        simpleMailMessage.setText("您有一个订单需要处理，订单号为"+orderId.toString()+"的顾客正在催单");
        mailSender.send(simpleMailMessage);
        try{
            webSocketUtils.sendToOne(msg,sid);
        }catch (Exception e){
            log.info("websocket发送失败");
        }


        return Result.success("催单成功");
    }
}
