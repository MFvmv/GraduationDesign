package com.hospital.mbg.mapper;

import com.hospital.mbg.model.FinancialrecordsInpatientsRelation;
import com.hospital.mbg.model.FinancialrecordsInpatientsRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancialrecordsInpatientsRelationMapper {
    long countByExample(FinancialrecordsInpatientsRelationExample example);

    int deleteByExample(FinancialrecordsInpatientsRelationExample example);

    int deleteByPrimaryKey(Integer InpatientID);

    int insert(FinancialrecordsInpatientsRelation row);

    int insertSelective(FinancialrecordsInpatientsRelation row);

    List<FinancialrecordsInpatientsRelation> selectByExample(FinancialrecordsInpatientsRelationExample example);

    FinancialrecordsInpatientsRelation selectByPrimaryKey(Integer InpatientID);

    int updateByExampleSelective(@Param("row") FinancialrecordsInpatientsRelation row, @Param("example") FinancialrecordsInpatientsRelationExample example);

    int updateByExample(@Param("row") FinancialrecordsInpatientsRelation row, @Param("example") FinancialrecordsInpatientsRelationExample example);

    int updateByPrimaryKeySelective(FinancialrecordsInpatientsRelation row);

    int updateByPrimaryKey(FinancialrecordsInpatientsRelation row);
}