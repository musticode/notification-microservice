package com.notification.userservice.service.impl;

import com.notification.userservice.dto.UserCreateRequest;
import com.notification.userservice.exception.user.UserNotFoundException;
import com.notification.userservice.model.User;
import com.notification.userservice.repository.UserRepository;
import com.notification.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found with id : " + userId));
    }

    @Override
    public User createUser(UserCreateRequest request) {
        return null;
    }
}
