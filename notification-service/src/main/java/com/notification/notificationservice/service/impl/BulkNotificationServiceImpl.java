package com.notification.notificationservice.service.impl;

import com.notification.notificationservice.dto.NotificationDto;
import com.notification.notificationservice.model.Notification;
import com.notification.notificationservice.model.PrioritizedNotification;
import com.notification.notificationservice.service.BulkNotificationService;
import com.notification.notificationservice.service.NotificationPrioritizerService;
import com.notification.notificationservice.service.ValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BulkNotificationServiceImpl implements BulkNotificationService {

    private final NotificationElasticServiceImpl notificationElasticService;
    private final NotificationPrioritizerService prioritizerService;
    private final ValidatorService validatorService;

    /**
     * liste şeklinde notification'lar geldi
     * gelen'lerin hepsini elastic'e kaydet
     * validator ve prioritezer'e gönder
     * valide et
     * prioritize et
     * gerekli tablolara yaz (priority'ye göre)
     * */
    @Override
    public void saveNotifications(List<Notification> notifications) {

        List<PrioritizedNotification> prioritizedNotifications =  new ArrayList<>();

        notifications.forEach(notification -> {

            if (validatorService.validate(notification)){
                PrioritizedNotification prioritizedNotification = prioritizerService.prioritizeNotification(notification);
                prioritizedNotifications.add(prioritizedNotification);
                notificationElasticService.saveAsync(notification);
                log.info("Send to elastic : {}" , notification);
            }

        });

    }

}
