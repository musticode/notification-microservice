package com.notification.notificationservice.service.impl;

import com.notification.notificationservice.dto.*;
import com.notification.notificationservice.dto.event.EmailEvent;
import com.notification.notificationservice.dto.event.SmsEvent;
import com.notification.notificationservice.model.Notification;
import com.notification.notificationservice.repository.NotificationElasticRepository;
import com.notification.notificationservice.repository.NotificationRepository;
import com.notification.notificationservice.service.NotificationService;
import com.notification.notificationservice.service.ValidatorService;
import com.notification.notificationservice.service.event.publisher.EmailEventPublisher;
import com.notification.notificationservice.service.event.publisher.SmsEventPublisher;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationElasticServiceImpl elasticService;
    private final ValidatorService validatorService;
    private final ModelMapper modelMapper;
    private final SmsEventPublisher smsEventPublisher;
    private final EmailEventPublisher emailEventPublisher;

    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationElasticServiceImpl elasticService, ValidatorService validatorService, ModelMapper modelMapper, SmsEventPublisher smsEventPublisher, EmailEventPublisher emailEventPublisher) {
        this.notificationRepository = notificationRepository;
        this.elasticService = elasticService;
        this.validatorService = validatorService;
        this.modelMapper = modelMapper;
        this.smsEventPublisher = smsEventPublisher;
        this.emailEventPublisher = emailEventPublisher;
    }

    @Override
    public NotificationDto saveNotification(NotificationRequest request) {

        //request'i al
        // validator'e gönder
        // eğer alanlar validse arkaplanda elastic'e kaydet
        // kullanıcıya cevap dön
        boolean isValid = validatorService.validate(request);
        if (isValid){
            if (request.getMessageType().equals(MessageType.SMS)){
                smsEventPublisher.publish(SmsEvent.builder()
                        .userId(request.getSender())
                        .type("SMS")
                        .status(Status.SENT)
                        .messageType(MessageType.SMS)
                        .subject(request.getSubject())
                        .messageBody(request.getMessageBody())
                        .sender(request.getSender())
                        .recipients(request.getRecipients())
                        .property(request.getProperty())
                        .build());
            }else if(request.getMessageType().equals(MessageType.EMAIL)){
                emailEventPublisher.publish(EmailEvent.builder()
                        .userId(request.getSender())
                        .type("SMS")
                        .status(Status.SENT)
                        .messageType(MessageType.SMS)
                        .subject(request.getSubject())
                        .messageBody(request.getMessageBody())
                        .sender(request.getSender())
                        .recipients(request.getRecipients())
                        .property(request.getProperty())
                        .build()
                );
            }

        }


        return null;
    }

    @Override
    public NotificationDto saveBulkNotification(BulkNotificationRequest request) {

        List<NotificationRequest> notificationRequests = request.getNotifications();
        List<Notification> notifications = notificationRequests.stream().map(this::mapRequestToEntity).toList();

        notifications.forEach(elasticService::saveAsync);

        return NotificationDto.builder()
                .success("true")
                .build();
    }

    @Override
    public NotificationResponse getNotificationWithId(int notificationId) {
        Notification notification = elasticService.findById(String.valueOf(notificationId));
        return mapToNotificationResponse(notification);
    }

    @Override
    public List<NotificationResponse> getAllNotifications() {
        return elasticService
                .getAllNotifications()
                .stream()
                .map(this::mapToNotificationResponse)
                .collect(toList());
    }

    @Override
    public NotificationResponse updateNotification(String notificationId, NotificationRequest request) {

        // todo update notification
        return null;
    }

    @Override
    public void deleteNotification(String notificationId) {
        //todo passive delete, update notification as isDeleted = true
        final Notification foundNotification = elasticService.findById(notificationId);

        if (!foundNotification.isDeleted()){
            foundNotification.setDeleted(true);
            log.info("Deleted : {}", foundNotification);
        }

    }

    public Notification mapRequestToEntity(NotificationRequest request){
        return modelMapper.map(request, Notification.class);
    }

    public NotificationDto mapToDto(Notification notification){
        return modelMapper.map(notification, NotificationDto.class);
    }

    private NotificationResponse mapToNotificationResponse(@NonNull Notification notification){
        return modelMapper.map(notification, NotificationResponse.class);
    }


    private void startVirtualThread(){



    }



}
