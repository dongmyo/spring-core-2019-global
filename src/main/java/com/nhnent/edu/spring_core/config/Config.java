package com.nhnent.edu.spring_core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.nhnent.edu.spring_core")
@Import(DatabaseConfig.class)
public class Config {

}