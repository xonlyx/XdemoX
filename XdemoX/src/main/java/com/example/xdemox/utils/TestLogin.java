package com.example.xdemox.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestLogin  implements HandlerInterceptor {
    @Autowired
    TokenUtils tokenUtils;

}
