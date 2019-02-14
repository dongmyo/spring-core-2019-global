package com.nhnent.edu.spring_core.repository;

import com.nhnent.edu.spring_core.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO : #7 JPA Repository interface which looks up MemberEntity. 
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
}
