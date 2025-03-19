package com.example.test;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class YmlCheckBean {

    @Value("${spring.application.name:未加载}")
    private String applicationName;

    @Value("${your.custom.property:未加载}")
    private String customProperty;

    @PostConstruct
    public void init() {
        System.out.println("spring.application.name: " + applicationName);
        System.out.println("your.custom.property: " + customProperty);
    }
}
