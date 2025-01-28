package com.notification.notificationservice.service.event.publisher;

import com.notification.notificationservice.dto.event.EmailEvent;
import com.notification.notificationservice.dto.event.Event;
import com.notification.notificationservice.dto.event.IosEvent;
import com.notification.notificationservice.dto.event.NotificationEvent;
import com.notification.notificationservice.service.event.NotificationEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class IosEventPublisher {



    private final NewTopic iosTopic;
    private final KafkaTemplate<String, IosEvent> kafkaTemplate;

    public void publish(IosEvent event) {

        // create message
        final Message<IosEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, iosTopic.name())
                .build();

        kafkaTemplate.send(message);
        log.info("Event is created : {}", event);

    }



}
