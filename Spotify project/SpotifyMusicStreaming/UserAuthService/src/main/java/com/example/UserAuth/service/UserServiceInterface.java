package com.example.UserAuth.service;

import com.example.UserAuth.domin.User;

import java.util.List;

public interface UserServiceInterface {

    public User registerUser(User user);
    public List<User>getAllUsers();
    public User loginCheck(String email,String password);
}
