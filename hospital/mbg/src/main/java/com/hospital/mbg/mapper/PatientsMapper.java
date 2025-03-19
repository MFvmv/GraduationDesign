package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Patients;
import com.hospital.mbg.model.PatientsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatientsMapper {
    long countByExample(PatientsExample example);

    int deleteByExample(PatientsExample example);

    int deleteByPrimaryKey(Integer PatientID);

    int insert(Patients row);

    int insertSelective(Patients row);

    List<Patients> selectByExampleWithBLOBs(PatientsExample example);

    List<Patients> selectByExample(PatientsExample example);

    Patients selectByPrimaryKey(Integer PatientID);

    int updateByExampleSelective(@Param("row") Patients row, @Param("example") PatientsExample example);

    int updateByExampleWithBLOBs(@Param("row") Patients row, @Param("example") PatientsExample example);

    int updateByExample(@Param("row") Patients row, @Param("example") PatientsExample example);

    int updateByPrimaryKeySelective(Patients row);

    int updateByPrimaryKeyWithBLOBs(Patients row);

    int updateByPrimaryKey(Patients row);
}