package com.hospital.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import com.hospital.common.config.CustomFilter;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.hospital.common",
        "com.hospital.externalservice",
        "com.hospital.admin",
        "com.hospital.security",
        "com.hospital.restful"
//        "com.hospital.search"
},excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = CustomFilter.class))
@MapperScan("com.hospital.admin.dao")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);

    }

}
