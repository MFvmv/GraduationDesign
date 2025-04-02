package com.hospital.admin.check;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

//@Component
public class MyBatisChecker {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 检查 MyBatis 是否正确加载了指定的 Mapper
     */
    public void checkMyBatisMappings() {
        Collection<?> mappedStatements = sqlSessionFactory.getConfiguration().getMappedStatements();

        System.out.println("=== MyBatis Mapper 自检开始 ===");
        boolean found = false;

        for (Object obj : mappedStatements) {
            if (!(obj instanceof MappedStatement)) {
                // 跳过不是 MappedStatement 的对象
                System.out.println("跳过对象类型: " + obj.getClass().getName());
                continue;
            }
            MappedStatement statement = (MappedStatement) obj;
            String statementId = statement.getId();
            if (statementId.contains("FinancialrecordsDao.updateOrderNumberByIdList")) {
                System.out.println("✔️ 找到映射语句: " + statementId);
                found = true;
                break;
            }
        }

        if (!found) {
            System.err.println("❌ 未找到映射语句: FinancialrecordsDao.updateOrderNumberByIdList");
            System.err.println("⚠️ 请检查以下内容：");
            System.err.println("1. Mapper XML 文件是否在指定路径下，例如：resources/mapper/FinancialrecordsDao.xml");
            System.err.println("2. XML 文件中方法 ID 是否正确：<update id=\"updateOrderNumberByIdList\">");
            System.err.println("3. application.yml 中是否正确配置了 mapper-locations");
            System.err.println("4. @Mapper 注解是否添加在接口上");
        }

        System.out.println("=== MyBatis Mapper 自检结束 ===");
    }
}

