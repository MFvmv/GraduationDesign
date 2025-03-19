package com.hospital.restful.domain;

import lombok.Data;

/**
 * 表字段信息类，表示从数据库中获取的字段信息。
 */
@Data
public class FieldsInfo {
    /**
     * 表的名称
     */
    private String tableName;

    /**
     * 字段类型，如 INT, VARCHAR 等
     */
    private String columnType;

    /**
     * 字段名称
     */
    private String columnName;

    /**
     * 字段定义（如数据类型的详细描述）
     */
    private String columnDefinition;
}

