package com.notification.userservice.service;

import com.notification.userservice.dto.UserCreateRequest;
import com.notification.userservice.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findUserById(long userId);

    User createUser(UserCreateRequest request);
}
