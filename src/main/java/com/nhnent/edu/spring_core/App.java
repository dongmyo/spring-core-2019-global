package com.nhnent.edu.spring_core;

import com.nhnent.edu.spring_core.config.Config;
import com.nhnent.edu.spring_core.service.NotificationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            NotificationService kakaoService = applicationContext.getBean("kakaoService", NotificationService.class);
            kakaoService.sendNotification("01099499102", "Welcome to Dooray Service");

            NotificationService smsService = applicationContext.getBean("smsService", NotificationService.class);
            smsService.sendNotification("01099499102", "Welcome to Dooray Service");
        }
    }

}
