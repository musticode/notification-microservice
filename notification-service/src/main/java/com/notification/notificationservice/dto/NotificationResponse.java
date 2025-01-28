package com.notification.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationResponse {

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
