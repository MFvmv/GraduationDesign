package com.hospital.admin.check;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

//@Component
public class MyBatisResourceChecker implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 三组路径
        String[] patterns = {
                "classpath*:dao/*.xml",
                "classpath*:com/**/mapper/*.xml"
        };

        System.out.println("=== MyBatis Mapper XML 检查开始 ===");
        for (String pattern : patterns) {
            System.out.println("检查路径模式: " + pattern);
            Resource[] resources = resolver.getResources(pattern);
            if (resources.length == 0) {
                System.err.println("❌ 未找到匹配的资源，请检查路径是否正确");
            } else {
                System.out.println("匹配到 " + resources.length + " 个资源：");
                for (Resource resource : resources) {
                    System.out.println(" - " + resource.getURL());
                }
            }
            System.out.println();
        }
        System.out.println("=== 检查结束 ===");
    }
}

