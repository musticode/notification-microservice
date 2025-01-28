package com.notification.notificationservice.repository;

import com.notification.notificationservice.model.Notification;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationElasticRepository extends ElasticsearchRepository<Notification, String> {
}
