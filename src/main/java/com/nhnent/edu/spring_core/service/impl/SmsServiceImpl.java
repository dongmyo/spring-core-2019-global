package com.nhnent.edu.spring_core.service.impl;

import com.nhnent.edu.spring_core.service.NotificationService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class SmsServiceImpl implements NotificationService {
    @Override
    public String getType() {
        return "sms";
    }

    @Override
    public boolean sendNotification(String phoneNumber, String message) {
        System.out.println("Trying to send message via SMS center. phoneNumber: " + phoneNumber);
        System.out.println("Success to send message");

        return true;
    }

}
