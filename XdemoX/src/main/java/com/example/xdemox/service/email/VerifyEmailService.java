package com.example.xdemox.service.email;

import com.example.xdemox.pojo.entity.Result;

public interface VerifyEmailService {
    public Result verifyEmail(String email, String code);
}
