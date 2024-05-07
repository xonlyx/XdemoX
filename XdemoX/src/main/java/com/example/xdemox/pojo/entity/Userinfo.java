package com.example.xdemox.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Userinfo {
    @TableId(type = IdType.AUTO)
    Integer id;
    String username;
    String telephone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updatetime;
    Integer moneyplus100;
    Integer scoreplus10;
    Integer creditscore;
    Integer orderamount;
    Integer skill1;
    Integer skill2;

}
