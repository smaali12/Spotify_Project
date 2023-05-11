package com.example.UserTrackService.service;



import com.example.UserTrackService.domin.Track;
import com.example.UserTrackService.domin.User;
import com.example.UserTrackService.exception.UserAlreadyExistException;
import com.example.UserTrackService.exception.UserNotFoundException;

public interface IUserService {


    public User registerUser(User user)throws UserAlreadyExistException;


}

