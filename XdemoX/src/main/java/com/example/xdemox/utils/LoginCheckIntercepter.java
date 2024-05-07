package com.example.xdemox.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.xdemox.context.BaseContext;
import com.example.xdemox.pojo.entity.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginCheckIntercepter implements HandlerInterceptor {
    @Autowired
    TokenUtils tokenUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURL().toString();
        String JWt=request.getHeader("token");
        if(!StringUtils.hasLength(JWt)){
            Result error =Result.error("NOT_Login");
            String msg = JSONObject.toJSONString(error);
            response.getWriter().write(msg);
            return false;
        }
        try {
            Claims claims = tokenUtils.parseJWtokenToGetId(JWt);
            Integer o = (Integer) claims.get("id");
            Long l = o.longValue();
            BaseContext.setThreadLocal(l);
        }catch ( Exception e){
            Result error =Result.error("logincheck_error");
            String msg = JSONObject.toJSONString(error);
            response.getWriter().write(msg);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
