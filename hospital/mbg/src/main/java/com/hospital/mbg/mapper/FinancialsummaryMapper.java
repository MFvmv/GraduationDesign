package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Financialsummary;
import com.hospital.mbg.model.FinancialsummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancialsummaryMapper {
    long countByExample(FinancialsummaryExample example);

    int deleteByExample(FinancialsummaryExample example);

    int insert(Financialsummary row);

    int insertSelective(Financialsummary row);

    List<Financialsummary> selectByExample(FinancialsummaryExample example);

    int updateByExampleSelective(@Param("row") Financialsummary row, @Param("example") FinancialsummaryExample example);

    int updateByExample(@Param("row") Financialsummary row, @Param("example") FinancialsummaryExample example);
}