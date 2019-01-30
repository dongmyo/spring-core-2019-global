package com.nhnent.edu.spring_core.repository;

import com.nhnent.edu.spring_core.domain.Member;

public interface MemberDao {
    Member getMember(String name);

    void insertMember(Member member);

    void updateMember(Member member);

}
