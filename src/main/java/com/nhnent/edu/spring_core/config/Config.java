package com.nhnent.edu.spring_core.config;

import com.nhnent.edu.spring_core.component.MemberService;
import com.nhnent.edu.spring_core.component.impl.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// TODO : #3 MemberService 빈을 찾지 못하도록 component scan의 base package 위치를 수정.
@ComponentScan("com.nhnent.edu.spring_core.service")
public class Config {
    // TODO : #4 명시적으로 MemberService 빈을 생성
    @Bean(initMethod = "init", destroyMethod = "destroy")
//    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl();
    }

}