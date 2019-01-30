package com.nhnent.edu.spring_core.repository;

import com.nhnent.edu.spring_core.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO : #5 기존 repository interface가 custom interface를 상속하도록 수정.
public interface MemberRepository extends MemberRepositoryCustom, JpaRepository<MemberEntity, String> {
}
