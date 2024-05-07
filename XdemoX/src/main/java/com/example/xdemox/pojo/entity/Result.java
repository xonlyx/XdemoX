package com.example.xdemox.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public static  Result success(Object data){
        return new Result(1,"success",data);
    }
    public static  Result success(){
        return new Result(1,"success",null);
    }
    public  static  Result error(String msg){
        return  new Result(0,msg,null);
    }
}
