package com.example.test;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class VerifyPathMatchingStrategy {

    @Autowired
    @Qualifier("requestMappingHandlerMapping")
    private RequestMappingHandlerMapping handlerMapping;

    @PostConstruct
    public void checkPathMatching() {
        if (handlerMapping.getPatternParser() == null) {
            System.out.println("配置成功：当前使用的是 AntPathMatcher (matching-strategy = ant_path_matcher)");
        } else {
            System.out.println("配置未生效：当前使用的是 PathPatternParser");
        }
    }
}
