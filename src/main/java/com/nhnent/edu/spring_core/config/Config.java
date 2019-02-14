package com.nhnent.edu.spring_core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

// TODO : #3 JoinPoint에서 method parameter name을 가져오기 위해서.
// TODO : #3 `@EnableAspectJAutoProxy(proxyTargetClass = true)` for retrieving the method parameter name from JoinPoint.
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ComponentScan("com.nhnent.edu.spring_core")
@Import(DatabaseConfig.class)
public class Config {

}