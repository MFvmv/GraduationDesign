package com.hospital.restful_generate.config;

import cn.hutool.setting.dialect.Props;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.hospital.restful_generate.mapper.IndexStatisticsMapper;
import com.hospital.restful_generate.utils.PropsUtils;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MyBatisPlusConfig {

    public static SqlSessionFactory getSqlSessionFactory() throws Exception {
        Props props = new Props();
        try (InputStream inputStream = MyBatisPlusConfig.class.getResourceAsStream("/" + "generator.properties")) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found: " + "generator.properties");
            }
            props.load(inputStream);
        }
        // 配置数据源
        DataSource dataSource = new PooledDataSource(
                "com.mysql.cj.jdbc.Driver",          // 数据库驱动
                props.getStr("dataSource.url"), props.getStr("dataSource.username"), props.getStr("dataSource.password")                        // 密码
        );
        // 创建 MybatisConfiguration 对象
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);

        // 添加分页插件或其他插件（可选）
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        configuration.addInterceptor(interceptor);

        // 手动注册你的 Mapper 接口
        configuration.addMapper(IndexStatisticsMapper.class);

        // 使用 MybatisSqlSessionFactoryBean 构建 SqlSessionFactory
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfiguration(configuration);
        // 如果有 XML 映射文件，设置 mapperLocations（否则可省略）
         sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
               .getResources("classpath*:mapper/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
}

