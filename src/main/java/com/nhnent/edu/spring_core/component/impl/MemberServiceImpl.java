package com.nhnent.edu.spring_core.component.impl;

import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.component.MemberService;
import com.nhnent.edu.spring_core.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// TODO : #3 MemberServiceImpl class도 패키지 이동.
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private NotificationService smsService;

    @Autowired
    @Qualifier("kakaoService")
    private NotificationService kakaoService;


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

    // TODO : #4 init(), destroy() 메쏘드를 구현.
    @Override
//    @PostConstruct
    public void init() {
        System.out.println("member inited");
    }

    @Override
//    @PreDestroy
    public void destroy() {
        System.out.println("member destroyed");
    }

}
