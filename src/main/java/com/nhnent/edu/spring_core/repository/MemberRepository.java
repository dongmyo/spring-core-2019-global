package com.nhnent.edu.spring_core.repository;

import com.nhnent.edu.spring_core.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO : #5 make MemberRepository extend MemberRepositoryCustom.
public interface MemberRepository extends MemberRepositoryCustom, JpaRepository<MemberEntity, String> {
}
