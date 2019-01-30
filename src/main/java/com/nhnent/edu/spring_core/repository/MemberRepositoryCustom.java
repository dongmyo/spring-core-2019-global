package com.nhnent.edu.spring_core.repository;

import com.nhnent.edu.spring_core.entity.MemberEntity;
import org.springframework.data.repository.NoRepositoryBean;

// TODO : #3 custom interface.
@NoRepositoryBean
public interface MemberRepositoryCustom {
    void update(MemberEntity member);

}
