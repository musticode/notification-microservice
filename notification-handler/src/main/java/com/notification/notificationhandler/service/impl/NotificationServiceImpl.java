package com.notification.notificationhandler.service.impl;

import com.notification.notificationhandler.model.Notification;
import com.notification.notificationhandler.service.NotificationCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationCacheService {

    private final RedisTemplate<String, Notification> redisTemplate;


    @Override
    public void putNotificationToCache(String senderKey, Notification notificationValue) {
        redisTemplate.opsForValue().set(senderKey, notificationValue, Duration.ofSeconds(50));
    }

    @Override
    public Notification getNotificationValueFromCache(String senderKey) {
        return redisTemplate.opsForValue().get(senderKey);
    }

}
