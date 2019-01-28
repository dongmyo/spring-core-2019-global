package com.nhnent.edu.spring_core;

import com.nhnent.edu.spring_core.config.Config;
import com.nhnent.edu.spring_core.service.NotificationService;
import com.nhnent.edu.spring_core.service.impl.KakaoServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        classicalStyle();
        dependencyInjectionStyle();
    }

    private static void classicalStyle() {
        NotificationService notificationService = new KakaoServiceImpl();
        notificationService.sendNotification("01099499102", "Welcome to Dooray Service");
    }

    private static void dependencyInjectionStyle() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            NotificationService notificationService = applicationContext.getBean(NotificationService.class);
            notificationService.sendNotification("01099499102", "Welcome to Dooray Service");
        }
    }

}
