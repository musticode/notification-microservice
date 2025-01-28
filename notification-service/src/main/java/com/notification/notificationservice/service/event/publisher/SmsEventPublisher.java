package com.notification.notificationservice.service.event.publisher;

import com.notification.notificationservice.dto.event.AndroidEvent;
import com.notification.notificationservice.dto.event.Event;
import com.notification.notificationservice.dto.event.NotificationEvent;
import com.notification.notificationservice.dto.event.SmsEvent;
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
public class SmsEventPublisher  {

    private final NewTopic smsTopic;
    private final KafkaTemplate<String, SmsEvent> kafkaTemplate;



    public void publish(SmsEvent event) {

        // create message
        final Message<SmsEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, smsTopic.name())
                .build();

        kafkaTemplate.send(message);
        log.info("Event is created : {}", event);

    }


}
