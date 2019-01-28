package com.nhnent.edu.spring_core.service.impl;

import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.service.MemberService;
import com.nhnent.edu.spring_core.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final NotificationService smsService;

    private final NotificationService kakaoService;


    public MemberServiceImpl(NotificationService smsService, NotificationService kakaoService) {
        this.smsService = smsService;
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
