package com.notification.notificationservice.service;

import com.notification.notificationservice.model.Notification;
import com.notification.notificationservice.model.PrioritizedNotification;

import java.util.List;

public interface NotificationPrioritizerService {
    PrioritizedNotification prioritizeNotification(Notification notification);
    PrioritizedNotification findPrioritizedNotificationById(String notificationId);
    List<PrioritizedNotification> findAllPrioritizedNotifications();
}
