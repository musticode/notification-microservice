package com.notification.notificationservice.service;

import com.notification.notificationservice.dto.NotificationRequest;
import com.notification.notificationservice.model.Notification;

public interface ValidatorService {
    boolean validate(Notification notification);
    boolean validate(NotificationRequest request);
}
