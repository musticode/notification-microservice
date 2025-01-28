package com.notification.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequest {
    private String type;
    private Status status;
    private MessageType messageType;
    private DeliveryType deliveryType;
    private String subject;
    private String messageBody;
    private String sender; //sender olmalı
    private List<Recipient> recipients; //recipient'lerin hepsi valid olmalı
    private String property;
    private int retryCount;
}
