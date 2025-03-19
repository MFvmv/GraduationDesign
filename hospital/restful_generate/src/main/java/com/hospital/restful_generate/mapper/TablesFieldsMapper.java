package com.hospital.restful_generate.mapper;

import com.hospital.restful.domain.FieldsInfo;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface TablesFieldsMapper {

    /**
     * 获取指定数据库模式下所有表的字段信息
     *
     * @param schema 数据库模式（schema）
     * @return 表信息列表
     */
    List<FieldsInfo> getTableFieldsInfo(String schema);

    default Map<String, Map<String,FieldsInfo>> getTableFieldsInfoToCombine(String schema){
        // Sample list of FieldsInfo objects
        List<FieldsInfo> fieldsInfoList = getTableFieldsInfo(schema);// ... your list initialization

        // Grouping by tableName
        Map<String, Map<String, FieldsInfo>> result = fieldsInfoList.stream()
                .collect(Collectors.groupingBy(
                        FieldsInfo::getTableName, // 外层分组：按 TableName 分组
                        Collectors.toMap(
                                FieldsInfo::getColumnName, // 内层分组：按 ColumnName 分组
                                Function.identity() // 保留 FieldsInfo 对象本身
                        )
                ));


        // Iterate and print the grouped result
//        groupedByTableName.forEach((tableName, fields) -> {
//            System.out.println("Table: " + tableName);
//            fields.forEach(field -> System.out.println(field));
//        });
        return result;
    }
}
