package com.example.xdemox.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    LoginCheckIntercepter loginCheckIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckIntercepter)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/register")
                .excludePathPatterns("/api/forget")
                .excludePathPatterns("/api/admin/login")
                .excludePathPatterns("/api/customer/login")
                .excludePathPatterns("/api/customer/register")
                .excludePathPatterns("/api/email/code")
                .excludePathPatterns("/api/email/verify")
        ;

    }


}
