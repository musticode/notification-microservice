package com.notification.notificationhandler.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailEvent {
    private String userId;
    private String notificationId;
    private String type;
    private String status;
    private String messageType;
    private String deliveryType;
    private String subject;
    private String messageBody;
    private String sender;
    private String recipient;
    private String property;
}

