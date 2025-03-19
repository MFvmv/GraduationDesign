package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Alipaytransactions;
import com.hospital.mbg.model.AlipaytransactionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlipaytransactionsMapper {
    long countByExample(AlipaytransactionsExample example);

    int deleteByExample(AlipaytransactionsExample example);

    int deleteByPrimaryKey(Integer AlipayTransactionID);

    int insert(Alipaytransactions row);

    int insertSelective(Alipaytransactions row);

    List<Alipaytransactions> selectByExample(AlipaytransactionsExample example);

    Alipaytransactions selectByPrimaryKey(Integer AlipayTransactionID);

    int updateByExampleSelective(@Param("row") Alipaytransactions row, @Param("example") AlipaytransactionsExample example);

    int updateByExample(@Param("row") Alipaytransactions row, @Param("example") AlipaytransactionsExample example);

    int updateByPrimaryKeySelective(Alipaytransactions row);

    int updateByPrimaryKey(Alipaytransactions row);
}