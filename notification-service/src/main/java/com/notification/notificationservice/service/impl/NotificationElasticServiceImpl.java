package com.notification.notificationservice.service.impl;

import com.notification.notificationservice.model.Notification;
import com.notification.notificationservice.repository.NotificationElasticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NotificationElasticServiceImpl {
    private final NotificationElasticRepository notificationElasticRepository;

    public NotificationElasticServiceImpl(NotificationElasticRepository notificationElasticRepository) {
        this.notificationElasticRepository = notificationElasticRepository;
    }

    public Notification findById(String id){
        return notificationElasticRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
    }

    public List<Notification> getAllNotifications(){
        return (List<Notification>) notificationElasticRepository.findAll();
    }

    public Notification updateNotification(String notificationId, Notification newNotification){
        //todo notification update
        return null;
    }

    public void deleteNotification(String id){
        Notification foundNotification = findById(id);
        notificationElasticRepository.delete(foundNotification);
    }

    @Async
    public void saveAsync(Notification notification){
        if (notification == null){
            throw new RuntimeException("Null notification");
        }
        notificationElasticRepository.save(notification);
    }

    /**
     * https://medium.com/@eomercelik/async-in-spring-e86173f61b56
     * */
}
