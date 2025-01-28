package com.notification.notificationservice.service;

import com.notification.notificationservice.dto.NotificationDto;
import com.notification.notificationservice.model.Notification;

import java.util.List;

public interface BulkNotificationService {
    void saveNotifications(List<Notification> notifications);
}
