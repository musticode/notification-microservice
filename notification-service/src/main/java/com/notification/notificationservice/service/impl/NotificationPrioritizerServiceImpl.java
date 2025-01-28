package com.notification.notificationservice.service.impl;

import com.notification.notificationservice.model.Notification;
import com.notification.notificationservice.model.PrioritizedNotification;
import com.notification.notificationservice.model.Priority;
import com.notification.notificationservice.repository.PrioritizedNotificationRepository;
import com.notification.notificationservice.service.NotificationPrioritizerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationPrioritizerServiceImpl implements NotificationPrioritizerService {

    private final PrioritizedNotificationRepository prioritizedNotificationRepository;

    @Override
    public PrioritizedNotification prioritizeNotification(Notification notification) {

        // gelen notification'un priority'sini al
        // retryCount değeri'ne göre priority ekle
        // ilgili priority'ye göre güncelle
        // priorrizedNotification tablosuna ekle

        if (notification.getPriority() < 0 || notification.getPriority() >5){
            throw new RuntimeException("Notification priority error");
        }

        PrioritizedNotification prioritizedNotification = new PrioritizedNotification();

        switch (notification.getPriority()){
            case 0:
                prioritizedNotification = PrioritizedNotification.builder()
                        .notificationId(notification.getId())
                        .priority(Priority.NO_PRIORITY)
                        .build();
                break;
            case 1:
                prioritizedNotification = PrioritizedNotification.builder()
                        .notificationId(notification.getId())
                        .priority(Priority.VERY_LOW)
                        .build();
                break;
            case 2:
                prioritizedNotification = PrioritizedNotification.builder()
                        .notificationId(notification.getId())
                        .priority(Priority.LOW)
                        .build();
                break;
            case 3:
                prioritizedNotification = PrioritizedNotification.builder()
                        .notificationId(notification.getId())
                        .priority(Priority.MEDIUM)
                        .build();
                break;
            case 4:
                prioritizedNotification = PrioritizedNotification.builder()
                        .notificationId(notification.getId())
                        .priority(Priority.HIGH)
                        .build();
                break;
            case 5:
                prioritizedNotification = PrioritizedNotification.builder()
                        .notificationId(notification.getId())
                        .priority(Priority.VERY_HIGH)
                        .build();
                break;
        }


        save(prioritizedNotification);
        return prioritizedNotification;
    }

    @Override
    public PrioritizedNotification findPrioritizedNotificationById(String notificationId) {
        return prioritizedNotificationRepository
                .findById(notificationId)
                .orElseThrow(()-> new RuntimeException("Not found with id " + notificationId));
    }

    @Override
    public List<PrioritizedNotification> findAllPrioritizedNotifications() {
        return null;
    }


    private PrioritizedNotification save(PrioritizedNotification prioritizedNotification){

        if (prioritizedNotification.getNotificationId().isEmpty() || prioritizedNotification.getNotificationId().isBlank()){
            log.warn("Priority error, empty or blank");
            throw new RuntimeException("Priority error");
        }

        return prioritizedNotificationRepository.save(prioritizedNotification);
    }

}
