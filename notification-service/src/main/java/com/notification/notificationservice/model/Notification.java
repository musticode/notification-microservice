package com.notification.notificationservice.model;

import com.notification.notificationservice.dto.DeliveryType;
import com.notification.notificationservice.dto.MessageType;
import com.notification.notificationservice.dto.Status;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Field(type = FieldType.Text)
    private String type;

    @Field(type = FieldType.Keyword)
    private Status status;

    @Field(type = FieldType.Keyword)
    private MessageType messageType;

    @Field(type = FieldType.Keyword)
    private DeliveryType deliveryType;

    @Field(type = FieldType.Text)
    private String subject;

    @Field(type = FieldType.Text)
    private String messageBody;

    @Field(type = FieldType.Text)
    private String sender;

    @Field(type = FieldType.Text)
    private String recipient;

    @Field(type = FieldType.Text)
    private String property;

    @Field(type = FieldType.Integer)
    private int retryCount;

    @Field(type = FieldType.Integer)
    private int priority;

    @Field(type = FieldType.Boolean)
    private boolean isDeleted;


}
