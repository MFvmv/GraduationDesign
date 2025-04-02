package com.hospital.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication(scanBasePackages = {"com.hospital.admin.config"})
public class AdminApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AdminApplication.class, args);
    }

}
