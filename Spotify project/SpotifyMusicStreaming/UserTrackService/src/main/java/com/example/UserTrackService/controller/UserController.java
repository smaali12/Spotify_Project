package com.example.UserTrackService.controller;



import com.example.UserTrackService.Proxy.UserProxy;
import com.example.UserTrackService.domin.Track;
import com.example.UserTrackService.domin.User;
import com.example.UserTrackService.exception.UserAlreadyExistException;
import com.example.UserTrackService.exception.UserNotFoundException;
import com.example.UserTrackService.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {


    private IUserService iUserService;


    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;

    }

    private ResponseEntity<?> responseEntity;


    // http://localhost:8084/api/v2/register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistException {
        try {
            responseEntity =  new ResponseEntity<>(iUserService.registerUser(user), HttpStatus.CREATED);
            System.out.println(responseEntity);
        }
        catch(UserAlreadyExistException e)
        {
            throw new UserAlreadyExistException();
        }

        return responseEntity;

    }


}
