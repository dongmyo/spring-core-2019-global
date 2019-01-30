package com.nhnent.edu.spring_core.repository;

import com.nhnent.edu.spring_core.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO : #7 MemberEntity를 조회할 JPA Repository interface.
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
}
