package com.hospital.restful.config;

import com.hospital.common.config.CustomFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {
        "com.hospital.common",
        "com.hospital.externalservice",
        "com.hospital.restful"
},excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = CustomFilter.class))
public class AppConfig {

}
