package com.example.UserTrackService.service;




import com.example.UserTrackService.Proxy.UserProxy;
import com.example.UserTrackService.domin.Track;
import com.example.UserTrackService.domin.User;
import com.example.UserTrackService.exception.UserAlreadyExistException;
import com.example.UserTrackService.exception.UserNotFoundException;
import com.example.UserTrackService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserServiceImpl implements IUserService {


    private UserRepo userRepo;
    private UserProxy uprox;
    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserProxy uprox) {
        this.userRepo = userRepo;
        this.uprox = uprox;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistException {
        if(userRepo.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistException();
        }
        uprox.register(user);
        return userRepo.save(user);

    }


    }




