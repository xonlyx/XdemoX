package com.example.xdemox.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {
    Integer pid;
    Integer cid;
    String city;
}
