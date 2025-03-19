package com.hospital.restful.domain;

import lombok.Data;

@Data
public class IndexStatistics {
    /**
     * 数据库名称
     * <p>
     * 表示该索引所在的数据库（schema）的名称。
     * </p>
     */
    private String tableSchema;

    /**
     * 表名称
     * <p>
     * 表示索引所在的具体数据库表的名称。
     * </p>
     */
    private String tableName;

    /**
     * 索引名称
     * <p>
     * 表示数据库中索引的名称，通常是主键、唯一索引或普通索引的名称。
     * </p>
     */
    private String indexName;

    /**
     * 列名称
     * <p>
     * 表示该索引中涉及到的具体列名，即该索引包含的列。
     * </p>
     */
    private String columnName;

    /**
     * 列在索引中的顺序
     * <p>
     * 表示该列在索引中的顺序，从 1 开始。通常用于复合索引，
     * 表示该索引由多个列组成，seqInIndex 指明了列的位置顺序。
     * </p>
     */
    private int seqInIndex;

    /**
     * 是否允许重复值
     * <p>
     * 表示该索引是否允许重复值。
     * 如果为 true，表示非唯一索引，允许重复；
     * 如果为 false，则表示唯一索引，不能存在重复值。
     * </p>
     */
    private boolean nonUnique;

    /**
     * 索引类型
     * <p>
     * 表示该索引的类型，例如 BTREE、HASH 等。
     * 通常用于说明数据库使用的索引结构类型。
     * </p>
     */
    private String indexType;

    /**
     * 排序规则
     * <p>
     * 表示索引中列的排序规则。
     * - 如果值为 'A'，表示升序（Ascending）。
     * - 如果值为 'D'，表示降序（Descending）。
     * - 如果值为 null，则表示未指定排序规则或不适用。
     * </p>
     */
    private String collation;
}

