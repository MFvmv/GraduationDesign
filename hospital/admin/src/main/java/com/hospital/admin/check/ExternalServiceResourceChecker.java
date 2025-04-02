package com.hospital.admin.check;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

//@Component
public class ExternalServiceResourceChecker implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 使用更宽泛的路径规则扫描externalservice模块下的所有xml文件
        String pattern = "classpath*:com/hospital/externalservice/**/*.xml";
        System.out.println("=== 检查 externalservice 模块 XML 文件 开始 ===");
        Resource[] resources = resolver.getResources(pattern);
        if (resources.length == 0) {
            System.err.println("❌ 未找到匹配的资源，请检查 externalservice 模块的资源配置和打包是否正确");
        } else {
            System.out.println("匹配到 " + resources.length + " 个资源：");
            for (Resource resource : resources) {
                System.out.println(" - " + resource.getURL());
            }
        }
        System.out.println("=== 检查结束 ===");
    }
}
