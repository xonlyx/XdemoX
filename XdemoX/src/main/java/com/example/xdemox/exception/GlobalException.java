package com.example.xdemox.exception;


import com.example.xdemox.pojo.entity.Result;
import com.example.xdemox.utils.WebSocketUtils;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @Autowired
    WebSocketUtils webSocketUtils;

    @ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
    public Result ex(org.springframework.web.HttpRequestMethodNotSupportedException ex){
        ex.printStackTrace();
        return Result.error("请求方式错误");
    }
    @ExceptionHandler(NullPointerException.class)
    public Result ex(NullPointerException ex){
        ex.printStackTrace();
        return Result.error("空对象异常");
    }

    @ExceptionHandler(org.mybatis.spring.MyBatisSystemException.class)
    public Result ex(org.mybatis.spring.MyBatisSystemException ex){
        ex.printStackTrace();
        return Result.error("Mysql异常");
    }

    @ExceptionHandler(java.time.format.DateTimeParseException.class)
    public Result ex(java.time.format.DateTimeParseException ex){
        ex.printStackTrace();
        return Result.error("时间格式错误");
    }

    @ExceptionHandler(java.lang.IllegalStateException.class)
    public  Result ex(java.lang.IllegalStateException ex){
        ex.printStackTrace();
        return Result.error("异常");
    }


    @ExceptionHandler(org.springframework.jdbc.BadSqlGrammarException.class)

    public Result ex(org.springframework.jdbc.BadSqlGrammarException ex){
        ex.printStackTrace();
        return Result.error("数据库查询异常，联系管理员");
    }


    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("联系管理员");
    }


}
