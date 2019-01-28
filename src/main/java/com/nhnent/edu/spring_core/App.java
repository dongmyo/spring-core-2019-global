package com.nhnent.edu.spring_core;

import com.nhnent.edu.spring_core.config.Config;
import com.nhnent.edu.spring_core.domain.Member;
import com.nhnent.edu.spring_core.service.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            MemberService memberService = applicationContext.getBean(MemberService.class);
            memberService.subscribe(new Member("김병부", "01099499102"));
        }
    }

}
