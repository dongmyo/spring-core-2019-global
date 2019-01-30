package com.nhnent.edu.spring_core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

// TODO : #5 @AspectJ 사용.
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.nhnent.edu.spring_core")
@Import(DatabaseConfig.class)
public class Config {

}