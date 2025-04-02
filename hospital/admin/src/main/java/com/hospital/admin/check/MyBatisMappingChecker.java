package com.hospital.admin.check;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

//@Component
public class MyBatisMappingChecker implements CommandLineRunner {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void run(String... args) throws Exception {
        // 预期映射语句ID（包含完整包名）
        String expectedId = "com.hospital.externalservice.dao.FinancialrecordsDao.updateOrderNumberByIdList";

        Configuration configuration = sqlSessionFactory.getConfiguration();
        // 注意：mappedStatements集合里可能包含 Ambiguity 对象
        Collection<?> mappedStatements = configuration.getMappedStatements();

        System.out.println("=== MyBatis Mapper 自检开始 ===");
        boolean found = false;
        for (Object obj : mappedStatements) {
            if (obj instanceof MappedStatement) {
                MappedStatement ms = (MappedStatement) obj;
                String id = ms.getId();
                System.out.println("映射语句: " + id);
                if (id.equals(expectedId)) {
                    System.out.println("✔️ 找到预期映射语句: " + id);
                    found = true;
                }
            } else {
                // 跳过非 MappedStatement 的对象（例如 Ambiguity 对象）
                System.out.println("跳过对象类型: " + obj.getClass().getName());
            }
        }
        if (!found) {
            System.err.println("❌ 未找到预期映射语句: " + expectedId);
            System.err.println("请检查以下几点：");
            System.err.println("1. 确认 mapper XML 文件已被正确复制到 classpath（例如 target/classes 目录中）。");
            System.err.println("2. 检查配置中的 mapper 扫描路径是否覆盖了该子模块的包。");
            System.err.println("3. 确保 XML 中的 namespace 与 DAO 接口的全限定名一致。");
        }
        System.out.println("=== MyBatis Mapper 自检结束 ===");
    }
}

