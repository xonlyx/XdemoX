package com.example.xdemox.service.impl.email;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.email.GetEmailService;
import com.example.xdemox.utils.LogWriterUtils;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class GetEmailServiceIImpl implements GetEmailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    private static final String[] CODE = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
            "Z"};

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    LogWriterUtils logWriterUtils;

    @Override
    public Result getcode(String email) {
        email = email.trim();
        if(email==null||email.equals("")){
            return Result.error("邮箱不能为空");
        }

        if (stringRedisTemplate.opsForValue().get("email_" + email) != null) {
            return Result.error("请勿重复发送");
        }

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("925192866@qq.com");
        simpleMailMessage.setTo(email);
        logWriterUtils.writeLog("发送验证码到邮箱："+email);
        simpleMailMessage.setSubject("验证码");
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            code += CODE[random.nextInt(62)];
        }
        simpleMailMessage.setText(code);
        mailSender.send(simpleMailMessage);
        stringRedisTemplate.opsForValue().set("email_" + email, code, 60, TimeUnit.SECONDS);
        return Result.success("发送成功");
    }
}
