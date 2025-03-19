package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Financialrecords;
import com.hospital.mbg.model.FinancialrecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancialrecordsMapper {
    long countByExample(FinancialrecordsExample example);

    int deleteByExample(FinancialrecordsExample example);

    int deleteByPrimaryKey(Integer TransactionID);

    int insert(Financialrecords row);

    int insertSelective(Financialrecords row);

    List<Financialrecords> selectByExampleWithBLOBs(FinancialrecordsExample example);

    List<Financialrecords> selectByExample(FinancialrecordsExample example);

    Financialrecords selectByPrimaryKey(Integer TransactionID);

    int updateByExampleSelective(@Param("row") Financialrecords row, @Param("example") FinancialrecordsExample example);

    int updateByExampleWithBLOBs(@Param("row") Financialrecords row, @Param("example") FinancialrecordsExample example);

    int updateByExample(@Param("row") Financialrecords row, @Param("example") FinancialrecordsExample example);

    int updateByPrimaryKeySelective(Financialrecords row);

    int updateByPrimaryKeyWithBLOBs(Financialrecords row);

    int updateByPrimaryKey(Financialrecords row);
}