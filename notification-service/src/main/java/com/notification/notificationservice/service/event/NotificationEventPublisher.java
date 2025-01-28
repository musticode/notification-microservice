package com.notification.notificationservice.service.event;

import com.notification.notificationservice.dto.event.Event;
import com.notification.notificationservice.dto.event.NotificationEvent;

public interface NotificationEventPublisher {
    void publish(Event event);
}
