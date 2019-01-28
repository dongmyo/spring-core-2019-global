package com.nhnent.edu.spring_core.config;

import com.nhnent.edu.spring_core.service.NotificationService;
import com.nhnent.edu.spring_core.service.impl.SmsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class DefaultNotificationServiceConfig {
    @Bean
    public NotificationService notificationService() {
        return new SmsServiceImpl();
    }

}