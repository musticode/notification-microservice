package com.notification.notificationservice.exception.recipient;

public class RecipientNotFoundException extends RuntimeException{
    public RecipientNotFoundException(String message){
        super(message);
    }
}
