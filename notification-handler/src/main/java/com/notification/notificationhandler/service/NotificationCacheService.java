package com.notification.notificationhandler.service;

import com.notification.notificationhandler.model.Notification;

public interface NotificationCacheService {
    void putNotificationToCache(String senderKey, Notification notificationValue);
    Notification getNotificationValueFromCache(String senderKey);
}
