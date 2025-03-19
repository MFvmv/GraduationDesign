package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Medicalrecords;
import com.hospital.mbg.model.MedicalrecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedicalrecordsMapper {
    long countByExample(MedicalrecordsExample example);

    int deleteByExample(MedicalrecordsExample example);

    int deleteByPrimaryKey(Integer RecordID);

    int insert(Medicalrecords row);

    int insertSelective(Medicalrecords row);

    List<Medicalrecords> selectByExampleWithBLOBs(MedicalrecordsExample example);

    List<Medicalrecords> selectByExample(MedicalrecordsExample example);

    Medicalrecords selectByPrimaryKey(Integer RecordID);

    int updateByExampleSelective(@Param("row") Medicalrecords row, @Param("example") MedicalrecordsExample example);

    int updateByExampleWithBLOBs(@Param("row") Medicalrecords row, @Param("example") MedicalrecordsExample example);

    int updateByExample(@Param("row") Medicalrecords row, @Param("example") MedicalrecordsExample example);

    int updateByPrimaryKeySelective(Medicalrecords row);

    int updateByPrimaryKeyWithBLOBs(Medicalrecords row);

    int updateByPrimaryKey(Medicalrecords row);
}