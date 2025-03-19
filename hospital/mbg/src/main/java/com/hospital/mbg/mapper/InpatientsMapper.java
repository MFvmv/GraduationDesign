package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Inpatients;
import com.hospital.mbg.model.InpatientsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InpatientsMapper {
    long countByExample(InpatientsExample example);

    int deleteByExample(InpatientsExample example);

    int deleteByPrimaryKey(Integer InpatientID);

    int insert(Inpatients row);

    int insertSelective(Inpatients row);

    List<Inpatients> selectByExample(InpatientsExample example);

    Inpatients selectByPrimaryKey(Integer InpatientID);

    int updateByExampleSelective(@Param("row") Inpatients row, @Param("example") InpatientsExample example);

    int updateByExample(@Param("row") Inpatients row, @Param("example") InpatientsExample example);

    int updateByPrimaryKeySelective(Inpatients row);

    int updateByPrimaryKey(Inpatients row);
}