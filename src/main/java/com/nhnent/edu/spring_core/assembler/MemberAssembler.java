package com.nhnent.edu.spring_core.assembler;

import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.entity.MemberEntity;

public class MemberAssembler {
    public Member toDto(MemberEntity memberEntity) {
        return new Member(memberEntity.getName(), memberEntity.getPhoneNumber());
    }

}
