package com.notification.userservice.controller;

import com.notification.userservice.dto.UserCreateRequest;
import com.notification.userservice.model.User;
import com.notification.userservice.service.UserService;
import jakarta.ws.rs.POST;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId){
        return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request){
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }


}
