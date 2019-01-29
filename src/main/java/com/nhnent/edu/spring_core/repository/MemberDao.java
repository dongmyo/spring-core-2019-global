package com.nhnent.edu.spring_core.repository;

import com.nhnent.edu.spring_core.domain.Member;

// TODO : #3 MemberDao 인터페이스 생성.
public interface MemberDao {
    Member getMember(String name);

    void insertMember(Member member);

    void updateMember(Member member);

}
