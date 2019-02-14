package com.nhnent.edu.spring_core.repository;

import com.nhnent.edu.spring_core.entity.MemberEntity;
import com.nhnent.edu.spring_core.entity.QMemberEntity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

// TODO : #4 custom interface implementation.
public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom {
    public MemberRepositoryImpl() {
        super(MemberEntity.class);
    }

    @Override
    public void update(MemberEntity member) {
        // TODO : #7 what if exception occurs here?
/*
        if ("global".equals(member.getName())) {
            throw new RuntimeException("exception occurred");
        }
*/

        QMemberEntity qMember = QMemberEntity.memberEntity;

        update(qMember).set(qMember.phoneNumber, member.getPhoneNumber())
                       .where(qMember.name.eq(member.getName()))
                       .execute();
    }

}
