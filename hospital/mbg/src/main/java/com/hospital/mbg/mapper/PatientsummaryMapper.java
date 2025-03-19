package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Patientsummary;
import com.hospital.mbg.model.PatientsummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatientsummaryMapper {
    long countByExample(PatientsummaryExample example);

    int deleteByExample(PatientsummaryExample example);

    int insert(Patientsummary row);

    int insertSelective(Patientsummary row);

    List<Patientsummary> selectByExample(PatientsummaryExample example);

    int updateByExampleSelective(@Param("row") Patientsummary row, @Param("example") PatientsummaryExample example);

    int updateByExample(@Param("row") Patientsummary row, @Param("example") PatientsummaryExample example);
}