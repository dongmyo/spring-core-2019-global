package com.nhnent.edu.spring_core.config;

import com.nhnent.edu.spring_core.service.NotificationService;
import com.nhnent.edu.spring_core.service.impl.KakaoServiceImpl;
import com.nhnent.edu.spring_core.service.impl.SmsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public NotificationService notificationService() {
        return new KakaoServiceImpl();
//        return new SmsServiceImpl();
    }

}