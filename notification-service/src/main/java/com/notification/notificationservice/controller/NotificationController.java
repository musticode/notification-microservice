package com.notification.notificationservice.controller;

import com.notification.notificationservice.dto.BulkNotificationRequest;
import com.notification.notificationservice.dto.NotificationDto;
import com.notification.notificationservice.dto.NotificationRequest;
import com.notification.notificationservice.dto.NotificationResponse;
import com.notification.notificationservice.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    public final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping
    public ResponseEntity<NotificationDto> saveNotification(NotificationRequest request){
        return new ResponseEntity<>(notificationService.saveNotification(request), HttpStatus.CREATED);
    }


    @PostMapping("/bulk")
    public ResponseEntity<NotificationDto> saveNotification(BulkNotificationRequest request){
        return new ResponseEntity<>(notificationService.saveBulkNotification(request), HttpStatus.CREATED);
    }


    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationResponse> getNotificationById(@PathVariable int notificationId){
        return new ResponseEntity<>(notificationService.getNotificationWithId(notificationId), HttpStatus.OK);
    }





}
