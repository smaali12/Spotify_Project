package com.example.UserTrackService.Proxy;

import com.example.UserTrackService.domin.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service",url ="localhost:8999" )
public interface UserProxy {

    @PostMapping("/users")
    public ResponseEntity<?> register (@RequestBody User user);
}
