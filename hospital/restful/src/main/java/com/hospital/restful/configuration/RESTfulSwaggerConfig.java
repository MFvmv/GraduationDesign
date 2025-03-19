package com.hospital.restful.configuration;

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
public class RESTfulSwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .groupName("RESTful")
                .apiBasePackage("com.hospital.restful.modules")
                .title("hospital后台系统")
                .description("RESTful后台相关接口文档")
                .contactName("MF")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public Docket getRESTfulDocket(){
        return super.createRestApi();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessorRESTful() {
        return generateBeanPostProcessor();
    }

}
