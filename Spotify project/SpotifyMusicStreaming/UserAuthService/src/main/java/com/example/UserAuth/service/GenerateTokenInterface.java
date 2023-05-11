package com.example.UserAuth.service;

//import com.example.course14sprint1mySql.domin.User;


import com.example.UserAuth.domin.User;

import java.util.Map;

public interface GenerateTokenInterface {

    Map<String,String> generateToken(User user);
}
