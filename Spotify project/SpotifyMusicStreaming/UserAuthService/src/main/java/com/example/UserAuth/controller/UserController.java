package com.example.UserAuth.controller;

import com.example.UserAuth.domin.User;
import com.example.UserAuth.service.GenerateTokenInterface;
import com.example.UserAuth.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping()
public class UserController {

    private UserServiceInterface userServiceInterface;
    private GenerateTokenInterface generateTokenInterface;

    @Autowired
    public UserController(UserServiceInterface userServiceInterface, GenerateTokenInterface generateTokenInterface) {
        this.userServiceInterface = userServiceInterface;
        this.generateTokenInterface = generateTokenInterface;
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<>(userServiceInterface.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userServiceInterface.registerUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logincheck(@RequestBody User user) {
        User result = userServiceInterface.loginCheck(user.getEmail(), user.getPassword());
        if (result != null)
        {
            Map<String, String> map = generateTokenInterface.generateToken( user);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity("invalid user", HttpStatus.NOT_FOUND);
        }
    }
}
