package com.example.xdemox.controller.email;

import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.service.email.GetEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetEmailController {
    @Autowired
    private GetEmailService getEmailService;


    @PostMapping("api/email/code")
    public Result getcode(String email) {
        return getEmailService.getcode(email);
    }
}
