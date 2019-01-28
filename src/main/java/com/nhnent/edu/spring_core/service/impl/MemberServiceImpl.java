package com.nhnent.edu.spring_core.service.impl;

import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.service.MemberService;
import com.nhnent.edu.spring_core.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private NotificationService smsService;

    private NotificationService kakaoService;


    @Autowired
    public void setSmsService(NotificationService smsService) {
        this.smsService = smsService;
    }

    @Autowired
    @Qualifier("kakaoService")
    public void setKakaoService(NotificationService kakaoService) {
        this.kakaoService = kakaoService;
    }


    @Override
    public boolean subscribe(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member is null");

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            smsService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
        }

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            kakaoService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
        }

        return true;
    }

}
