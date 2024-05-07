package com.example.xdemox.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TokenUtils {
    private  static final String string="asdjnbnhasuhdinuioweuirno12389hfwdhu8sf8";

    public  String createJWtoken(Integer id){
        Map<String,Object> claims =new HashMap<>();
        claims.put("id",id);

        String JWt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, string)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        return  JWt;
    }

    public Claims parseJWtokenToGetId(String JWt){
        log.info(JWt);
        Claims body = Jwts.parser()
                .setSigningKey(string)
                .parseClaimsJws(JWt)
                .getBody();
        return  body;
    }



}
