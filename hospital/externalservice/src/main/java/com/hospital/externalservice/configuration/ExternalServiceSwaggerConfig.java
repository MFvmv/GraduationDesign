package com.hospital.externalservice.configuration;


import com.hospital.common.config.BaseSwaggerConfig;
import com.hospital.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class ExternalServiceSwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .groupName("externalservice")
                .apiBasePackage("com.hospital.externalservice.controller")
                .title("mall前台系统")
                .description("hospital的外部服务")
                .contactName("MF")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public Docket getExternalServiceDocket(){
        return super.createRestApi();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessorExternalService() {
        return generateBeanPostProcessor();
    }
}
