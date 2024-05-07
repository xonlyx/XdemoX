package com.example.xdemox.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
    private String msg;
    private boolean IsToMSG;
    private boolean IsToFront;
}
