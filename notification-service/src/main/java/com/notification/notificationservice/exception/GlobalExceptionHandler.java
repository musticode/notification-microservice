package com.notification.notificationservice.exception;

import com.notification.notificationservice.exception.recipient.RecipientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RecipientNotFoundException.class})
    public ResponseEntity<String> handleRecipientNotFoundException(RecipientNotFoundException exception){
        return new ResponseEntity<>("Exception message", HttpStatus.NOT_FOUND);
    }

}
