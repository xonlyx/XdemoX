package com.example.xdemox.service.impl.email;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.email.VerifyEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VerifyEmailServiceImpl implements VerifyEmailService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Override
    public Result verifyEmail(String email, String code) {
        email = email.trim();
        if(email==null||email.equals("")){
            return Result.error("邮箱不能为空");
        }

        String s = stringRedisTemplate.opsForValue().get("email_" + email);
        if (s == null) {
            return Result.error("验证码已过期");
        }
        if (!s.equals(code)) {
            return Result.error("验证码错误");
        }
        stringRedisTemplate.delete("email_" + email);
        return Result.success("验证成功");

    }
}
