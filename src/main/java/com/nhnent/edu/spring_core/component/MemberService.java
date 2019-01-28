package com.nhnent.edu.spring_core.component;

import com.nhnent.edu.spring_core.domain.Member;

// TODO : #1 MemberService interface를 패키지 이동.
public interface MemberService {
    boolean subscribe(Member member);

    // TODO : #2 init(), destroy() 메쏘드를 선언.
/**/
    void init();
    void destroy();
/**/

}
