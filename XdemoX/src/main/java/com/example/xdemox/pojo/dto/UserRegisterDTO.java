package com.example.xdemox.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {
     String telephone;
     String password;
     String username;
     Integer skill1;
     Integer skill2;
}
