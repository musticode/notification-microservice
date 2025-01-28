package com.notification.notificationservice.service.event.publisher;

import com.notification.notificationservice.dto.event.EmailEvent;
import com.notification.notificationservice.dto.event.SmsEvent;
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
public class EmailEventPublisher {

    private final NewTopic emailTopic;
    private final KafkaTemplate<String, EmailEvent> kafkaTemplate;


    public void publish(EmailEvent event) {

        // create message
        final Message<EmailEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, emailTopic.name())
                .build();

        kafkaTemplate.send(message);
        log.info("Event is created : {}", event);

    }

}
