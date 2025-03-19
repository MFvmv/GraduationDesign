package com.hospital.mbg.mapper;

import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelation;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancialrecordsMedicalrecordsRelationMapper {
    long countByExample(FinancialrecordsMedicalrecordsRelationExample example);

    int deleteByExample(FinancialrecordsMedicalrecordsRelationExample example);

    int deleteByPrimaryKey(Integer RecordID);

    int insert(FinancialrecordsMedicalrecordsRelation row);

    int insertSelective(FinancialrecordsMedicalrecordsRelation row);

    List<FinancialrecordsMedicalrecordsRelation> selectByExample(FinancialrecordsMedicalrecordsRelationExample example);

    FinancialrecordsMedicalrecordsRelation selectByPrimaryKey(Integer RecordID);

    int updateByExampleSelective(@Param("row") FinancialrecordsMedicalrecordsRelation row, @Param("example") FinancialrecordsMedicalrecordsRelationExample example);

    int updateByExample(@Param("row") FinancialrecordsMedicalrecordsRelation row, @Param("example") FinancialrecordsMedicalrecordsRelationExample example);

    int updateByPrimaryKeySelective(FinancialrecordsMedicalrecordsRelation row);

    int updateByPrimaryKey(FinancialrecordsMedicalrecordsRelation row);
}