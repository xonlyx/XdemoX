package com.example.xdemox.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @TableId(type = IdType.AUTO)
        Integer id;
        Integer customerid;
        String address;
        Integer city;
        Integer province;
        Integer weight;
}
