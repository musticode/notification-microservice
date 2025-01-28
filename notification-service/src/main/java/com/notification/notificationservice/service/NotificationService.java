package com.notification.notificationservice.service;

import com.notification.notificationservice.dto.BulkNotificationRequest;
import com.notification.notificationservice.dto.NotificationDto;
import com.notification.notificationservice.dto.NotificationRequest;
import com.notification.notificationservice.dto.NotificationResponse;

import java.util.List;

public interface NotificationService {
    NotificationDto saveNotification(NotificationRequest request);

    NotificationDto saveBulkNotification(BulkNotificationRequest request);

    NotificationResponse getNotificationWithId(int notificationId);

    List<NotificationResponse> getAllNotifications();
    NotificationResponse updateNotification(String notificationId, NotificationRequest request);

    void deleteNotification(String notificationId);
}
