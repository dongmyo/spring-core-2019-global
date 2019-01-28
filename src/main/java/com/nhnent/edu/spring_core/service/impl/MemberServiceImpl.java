package com.nhnent.edu.spring_core.service.impl;

import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.service.MemberService;
import com.nhnent.edu.spring_core.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    // TODO : #3 NotificationService 타입 bean을 하나만 참조.
    private final NotificationService notificationService;


    public MemberServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @Override
    public boolean subscribe(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member is null");

        // TODO : #4 notificationService 하나로만 notification 전송하도록 수정.
        //      -> 실행: throws NoUniqueBeanDefinitionException.
        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            notificationService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
        }

        return true;
    }

}
