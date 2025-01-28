package com.notification.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipient {
    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String mobilDeviceId;
}
