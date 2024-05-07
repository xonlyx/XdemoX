package com.example.xdemox.controller.email;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.email.VerifyEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerifyEmailController {

    @Autowired
    private VerifyEmailService verifyEmailService;

    @PostMapping("/api/email/verify")
    public Result verifyEmail(String email, String code) {
        return verifyEmailService.verifyEmail(email, code);
    }
}
