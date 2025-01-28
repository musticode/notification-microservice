package com.notification.notificationservice.repository;

import com.notification.notificationservice.model.PrioritizedNotification;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrioritizedNotificationRepository extends ElasticsearchRepository<PrioritizedNotification, String> {
}
