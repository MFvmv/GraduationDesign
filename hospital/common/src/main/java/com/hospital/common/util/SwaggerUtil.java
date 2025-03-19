package com.hospital.common.util;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SwaggerUtil {
    public static Predicate<RequestHandler> basePackage(final String basePackages) {
        List<Predicate<RequestHandler>> predicates = Arrays.stream(basePackages.split(","))
                .map(String::trim)
                .map(RequestHandlerSelectors::basePackage)
                .collect(Collectors.toList());

        return input -> predicates.stream().anyMatch(predicate -> predicate.test(input));
    }
}
