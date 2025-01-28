package com.notification.notificationservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.topic.sms-topic}")
    private String smsTopicName;

    @Value("${spring.kafka.topic.email-topic}")
    private String emailTopicName;

    @Value("${spring.kafka.topic.ios-topic}")
    private String androidTopicName;

    @Value("${spring.kafka.topic.android-topic}")
    private String iosTopicName;

    @Bean
    public NewTopic smsTopic(){
        return TopicBuilder.name(smsTopicName)
                .build();
    }

    @Bean
    public NewTopic emailTopic(){
        return TopicBuilder.name(emailTopicName)
                .build();
    }

    @Bean
    public NewTopic iosTopic(){
        return TopicBuilder.name(iosTopicName)
                .build();
    }

    @Bean
    public NewTopic androidTopic(){
        return TopicBuilder.name(androidTopicName)
                .build();
    }


    // https://github.com/musticode/documents/blob/main/kafka-guide.md
}
