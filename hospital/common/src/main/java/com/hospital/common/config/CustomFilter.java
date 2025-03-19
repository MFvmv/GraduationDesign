package com.hospital.common.config;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import java.io.IOException;

public class CustomFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取类的全限定名
        String className = metadataReader.getClassMetadata().getClassName();

        // 排除 com.hospital.common、com.hospital.admin、com.hospital.security
        if (className.matches("com\\.hospital\\.(common|admin|security)\\..*")) {
            return false;
        }

        // 使用正则表达式匹配 "com.hospital.xx.config" 和 "com.hospital.xx.xxApplication"
        boolean matches = className.matches("com\\.hospital\\.[^.]+\\.config\\..*") ||
                className.matches("com\\.hospital\\.[^.]+\\.[^.]+Application");

        if (matches) {
            System.out.println("Filtered class: " + className);
        }

        return matches;
    }
}
