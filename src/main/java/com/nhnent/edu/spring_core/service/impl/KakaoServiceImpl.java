package com.nhnent.edu.spring_core.service.impl;

import com.nhnent.edu.spring_core.service.NotificationService;
import org.springframework.stereotype.Service;

// TODO : #2 빈 이름 제거.
//@Service("kakaoService")
@Service
public class KakaoServiceImpl implements NotificationService {
    @Override
    public boolean sendNotification(String phoneNumber, String message) {
        System.out.println("Trying to send message via Kakao. phoneNumber: " + phoneNumber);
        System.out.println("Success to send message");

        return true;
    }

}
