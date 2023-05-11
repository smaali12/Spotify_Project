package com.example.UserAuth.service;

import com.example.UserAuth.domin.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImpOfGenerateToken implements GenerateTokenInterface {
    @Override
    public Map<String, String> generateToken(User user) {

        String jwtToken=null; //creating variable we are storing data in it

        jwtToken= Jwts.builder()// jetbuilder instance
                .setSubject(user.getFirstName())// set username
                .setIssuedAt(new Date())// date
                .signWith(SignatureAlgorithm.HS256,"securityKey")// algo and key will check at the time of filter
                .compact();//storing string

        Map<String,String> map=new HashMap<>();//implementation of map
        map.put("token",jwtToken);//key:value
        map.put("message","User successfully loggedIn");
        return map;
    }



}
