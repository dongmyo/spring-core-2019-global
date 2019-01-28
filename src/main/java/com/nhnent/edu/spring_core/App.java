package com.nhnent.edu.spring_core;

import com.nhnent.edu.spring_core.service.NotificationService;
import com.nhnent.edu.spring_core.service.impl.SmsServiceImpl;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try (StaticApplicationContext applicationContext = new StaticApplicationContext()) {
            applicationContext.registerBeanDefinition("notificationService",
                                                      new RootBeanDefinition(SmsServiceImpl.class));

            NotificationService notificationService = applicationContext.getBean(NotificationService.class);
            notificationService.sendNotification("01099499102", "Welcome to Dooray Service");
        }
    }

}
