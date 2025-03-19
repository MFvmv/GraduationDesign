package com.hospital.mbg.mapper;

import com.hospital.mbg.model.FinancialrecordsDrugconsumptionRelation;
import com.hospital.mbg.model.FinancialrecordsDrugconsumptionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancialrecordsDrugconsumptionRelationMapper {
    long countByExample(FinancialrecordsDrugconsumptionRelationExample example);

    int deleteByExample(FinancialrecordsDrugconsumptionRelationExample example);

    int deleteByPrimaryKey(Integer ConsumptionID);

    int insert(FinancialrecordsDrugconsumptionRelation row);

    int insertSelective(FinancialrecordsDrugconsumptionRelation row);

    List<FinancialrecordsDrugconsumptionRelation> selectByExample(FinancialrecordsDrugconsumptionRelationExample example);

    FinancialrecordsDrugconsumptionRelation selectByPrimaryKey(Integer ConsumptionID);

    int updateByExampleSelective(@Param("row") FinancialrecordsDrugconsumptionRelation row, @Param("example") FinancialrecordsDrugconsumptionRelationExample example);

    int updateByExample(@Param("row") FinancialrecordsDrugconsumptionRelation row, @Param("example") FinancialrecordsDrugconsumptionRelationExample example);

    int updateByPrimaryKeySelective(FinancialrecordsDrugconsumptionRelation row);

    int updateByPrimaryKey(FinancialrecordsDrugconsumptionRelation row);
}