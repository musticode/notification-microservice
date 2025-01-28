package com.notification.notificationservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String id;
    private String email;
    private String username;
    private String firstname;
    private String lastname;
    private String phone;
    private String mobilDeviceId;
}
