package com.notification.notificationhandler.service.consumer;

import com.notification.notificationhandler.event.EmailEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailEventConsumer {


    @KafkaListener(
            topics = "${spring.kafka.topic.email-topic}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(EmailEvent event){


        log.info("Email event is consumed : {}", event);

    }

}
