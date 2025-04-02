package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Doctors;
import com.hospital.mbg.model.DoctorsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorsMapper {
    long countByExample(DoctorsExample example);

    int deleteByExample(DoctorsExample example);

    int deleteByPrimaryKey(Integer DoctorID);

    int insert(Doctors row);

    int insertSelective(Doctors row);

    List<Doctors> selectByExample(DoctorsExample example);

    Doctors selectByPrimaryKey(Integer DoctorID);

    int updateByExampleSelective(@Param("row") Doctors row, @Param("example") DoctorsExample example);

    int updateByExample(@Param("row") Doctors row, @Param("example") DoctorsExample example);

    int updateByPrimaryKeySelective(Doctors row);

    int updateByPrimaryKey(Doctors row);
}