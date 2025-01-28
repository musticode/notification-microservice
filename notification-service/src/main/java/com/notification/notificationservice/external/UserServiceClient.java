package com.notification.notificationservice.external;

import com.notification.notificationservice.dto.client.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("USER-SERVICE")
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/findAllUsers")
    List<User> getAllUsers();

    @GetMapping("/api/users/{userId}")
    User findUserById(@PathVariable String userId);

//    @PostMapping
//    ResponseEntity<User> createUser(@RequestBody UserCreateRequest request);

}
