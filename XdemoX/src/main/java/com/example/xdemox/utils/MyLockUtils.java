package com.example.xdemox.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class MyLockUtils {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public  boolean trylock(String lockk){

        return stringRedisTemplate.opsForValue().setIfAbsent(lockk,"1" ,10,java.util.concurrent.TimeUnit.SECONDS);
    }

    public  void unlock(String lockk){
        stringRedisTemplate.delete(lockk);
    }

}
