package com.hospital.admin.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(basePackages = {
        "com.hospital.common",
        "com.hospital.externalservice",
        "com.hospital.admin",
        "com.hospital.security",
        "com.hospital.restful"
//        "com.hospital.search"
},excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = CustomFilter.class))
public class AppConfig {

}
