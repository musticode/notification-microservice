package com.notification.notificationservice.dto.event;

import com.notification.notificationservice.dto.DeliveryType;
import com.notification.notificationservice.dto.MessageType;
import com.notification.notificationservice.dto.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEvent {
    private String id;
    private String type;
    private Status status;
    private MessageType messageType;
    private DeliveryType deliveryType;
    private String subject;
    private String messageBody;
    private String sender;
    private String recipient;
    private String property;
    private int retryCount;
}
