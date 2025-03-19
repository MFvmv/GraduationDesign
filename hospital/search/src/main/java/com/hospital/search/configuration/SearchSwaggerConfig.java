package com.hospital.search.configuration;

import com.hospital.common.config.BaseSwaggerConfig;
import com.hospital.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SearchSwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .groupName("search")
                .apiBasePackage("com.hospital.search.controller")
                .title("hospital搜索系统")
                .description("hospital搜索相关接口文档")
                .contactName("MF")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public Docket getSearchDocketSearch(){
        return super.createRestApi();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessorSearch() {
        return generateBeanPostProcessor();
    }
}
