package com.notification.userservice.exception.user;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String reason){
        super(reason);
    }
}
