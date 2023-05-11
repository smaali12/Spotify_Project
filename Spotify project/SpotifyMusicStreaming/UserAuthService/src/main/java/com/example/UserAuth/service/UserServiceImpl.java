package com.example.UserAuth.service;

import com.example.UserAuth.domin.User;
import com.example.UserAuth.repository.UserRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface{


    private UserRepoInterface userRepoInterface;

    @Autowired
    public UserServiceImpl(UserRepoInterface userRepoInterface) {
        this.userRepoInterface = userRepoInterface;
    }




    @Override
    public User registerUser(User user) {
        return userRepoInterface.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepoInterface.findAll();
    }

    @Override
    public User loginCheck(String email, String password) {
        if (userRepoInterface.findById(email).isPresent())
        {
            User user=userRepoInterface.findById(email).get();

            if(user.getPassword().equals(password))
            {
                user.setPassword("*******");
                return user;
            }else
            {
                return null;
            }
        }else{
            //user not exits
            return null;
        }
    }
}
