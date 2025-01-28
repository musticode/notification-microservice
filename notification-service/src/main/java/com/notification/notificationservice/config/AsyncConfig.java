package com.notification.notificationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(3);
        executor.setThreadNamePrefix("AsynchThread-");
        executor.initialize();
        return executor;
    }

}

/**
 * ÖNEMLİ BİR NOT : @Async annotationu kullanırken dikkat edilmesi gereken 2 kural vardır.
 * 1. Method public olmalıdır.
 * 2. Aynı class içerisinden @Async bir methodu çağırırsanız çağrılan method asynchronous olarak çalışmaz.
 * */
