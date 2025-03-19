package com.hospital.restful_generate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.restful.domain.IndexStatistics;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface IndexStatisticsMapper extends BaseMapper<IndexStatistics> {

    @Select("SELECT TABLE_SCHEMA AS tableSchema, TABLE_NAME AS tableName, " +
            "INDEX_NAME AS indexName, COLUMN_NAME AS columnName, " +
            "SEQ_IN_INDEX AS seqInIndex, INDEX_TYPE AS indexType, " +
            "`COLLATION` AS `collation` " +
            "FROM information_schema.STATISTICS " +
            "WHERE TABLE_SCHEMA = #{schema} AND INDEX_NAME = #{indexName}")
    List<IndexStatistics> getIndexStatistics(String schema,String indexName);
}
