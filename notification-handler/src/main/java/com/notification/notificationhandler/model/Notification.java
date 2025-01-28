package com.notification.notificationhandler.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    private String id;
    private String title;
    private String sender;
    private String receiver;
}
