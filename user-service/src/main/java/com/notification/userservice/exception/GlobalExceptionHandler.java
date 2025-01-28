package com.notification.userservice.exception;

import com.notification.userservice.dto.ExceptionResponse;
import com.notification.userservice.exception.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException exception){
        final ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .reason(String.valueOf(exception.getCause()))
                .path(exception.getLocalizedMessage())
                .status(404)
                .build();

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
