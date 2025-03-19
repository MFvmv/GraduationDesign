package com.hospital.mbg.generator.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.util.List;

public class KeepOriginalColumnNamePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true; // 插件验证通过
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        // 遍历表的所有列
        for (IntrospectedColumn column : introspectedTable.getAllColumns()) {
            String originalColumnName = column.getActualColumnName();
            column.setJavaProperty(originalColumnName); // 设置字段名为原始数据库字段名
        }
        super.initialized(introspectedTable);
    }
}
