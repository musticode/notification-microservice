package com.notification.notificationservice.service.impl;

import com.notification.notificationservice.dto.MessageType;
import com.notification.notificationservice.dto.NotificationRequest;
import com.notification.notificationservice.dto.client.User;
import com.notification.notificationservice.exception.recipient.RecipientNotFoundException;
import com.notification.notificationservice.external.UserServiceClient;
import com.notification.notificationservice.model.Notification;
import com.notification.notificationservice.service.ValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ValidatorServiceImpl implements ValidatorService {

    //private final UserService userService;
    private final UserServiceClient userServiceClient;

    @Override
    public boolean validate(Notification notification) {

        if (notification.getSender().isBlank() || notification.getSender().isEmpty()){
            log.warn("Sender is blank or empty");
            return false;
        }

        return true;
    }

    @Override
    public boolean validate(NotificationRequest request) {

        // user service'e git ve sender'ın id'si ile sorgula [TEK]
        final User foundSender = userServiceClient.findUserById(request.getSender());

        // sender yoksa hata dön
        if (foundSender.getId().isBlank()){
            log.warn("Sender is blank");
            throw new RecipientNotFoundException("Sender is blank");
        }

        request.getRecipients().forEach(recipient -> {
            if (userServiceClient.findUserById(recipient.getId()).getId().isBlank()){
                log.warn("Recipient is blank");
                throw new RecipientNotFoundException("Recipient is blank");
            }
        });

        // eğer böyle bi sender yoksa hata dön
        // user service'e recipient listesi ile git sorgula [BULK]
        // böyle bi recipient yoksa hata al

        return true;
    }

}
