package com.hospital.mbg.generator.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class UseGeneratedKeysPlugin extends PluginAdapter {

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element,
                                                IntrospectedTable introspectedTable) {
        System.out.println("------------------------------sqlMapInsertElementGenerated-------------------------------");
        return GeneratedInsertReturnId(element,introspectedTable);
    }
    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        System.out.println("------------------------------sqlMapInsertSelectiveElementGenerated-------------------------------");
        return GeneratedInsertReturnId(element,introspectedTable);
    }

    private boolean GeneratedInsertReturnId(XmlElement element,
                                            IntrospectedTable introspectedTable){
        // 获取主键列列表
        List<IntrospectedColumn> pkColumns = introspectedTable.getPrimaryKeyColumns();
        if (pkColumns == null || pkColumns.isEmpty()) {
            // 如果没有指定主键，则跳过该表的 useGeneratedKeys 配置
            System.out.println("Table " + introspectedTable.getFullyQualifiedTable() +
                    " does not have a primary key defined. Skipping useGeneratedKeys.");
            return true;
        }
        // 如果有多个主键，建议也跳过或者按业务需求处理
        if (pkColumns.size() > 1) {
            System.out.println("Table " + introspectedTable.getFullyQualifiedTable() +
                    " has multiple primary keys. Skipping useGeneratedKeys.");
            return true;
        }
        System.out.println(pkColumns.get(0));
        // 如果只有一个主键，则添加 useGeneratedKeys 和 keyProperty 属性
        IntrospectedColumn pkColumn = pkColumns.get(0);
        element.addAttribute(new Attribute("useGeneratedKeys", "true"));
        element.addAttribute(new Attribute("keyProperty", pkColumn.getJavaProperty()));

        return true;
    }


    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
}