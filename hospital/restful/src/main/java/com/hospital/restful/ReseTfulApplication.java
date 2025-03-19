package com.hospital.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hospital.restful.config")
public class ReseTfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReseTfulApplication.class, args);
    }

}
