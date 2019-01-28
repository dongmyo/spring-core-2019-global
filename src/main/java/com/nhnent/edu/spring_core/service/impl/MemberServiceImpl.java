package com.nhnent.edu.spring_core.service.impl;

import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.repository.NotiLogDao;
import com.nhnent.edu.spring_core.service.MemberService;
import com.nhnent.edu.spring_core.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private NotificationService smsService;

    @Autowired
    @Qualifier("kakaoService")
    private NotificationService kakaoService;

    // TODO : #7 실습 - field injection을 이용하여 NotiLogData 빈을 주입하세요.
    private NotiLogDao notiLogDao;


    @Override
    public boolean subscribe(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member is null");

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            smsService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
            // TODO : #8 noti 발송 내역을 로그로 남깁니다.
            int logId = notiLogDao.insertLog(member, "sms");
            System.out.println(notiLogDao.getLog(logId));
        }

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            kakaoService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
            // TODO : #9 noti 발송 내역을 로그로 남깁니다.
            int logId = notiLogDao.insertLog(member, "kakao");
            System.out.println(notiLogDao.getLog(logId));
        }

        return true;
    }

}
