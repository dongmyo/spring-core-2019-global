package com.nhnent.edu.spring_core.config;

import com.nhnent.edu.spring_core.service.PackageMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = { PackageMarker.class })
public class Config {

}