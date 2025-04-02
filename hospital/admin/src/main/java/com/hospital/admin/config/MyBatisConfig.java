package com.hospital.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by macro on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.hospital.admin.dao","com.hospital.mbg.mapper","com.hospital.externalservice.dao","com.hospital.restful.dao"})
public class MyBatisConfig {

}
