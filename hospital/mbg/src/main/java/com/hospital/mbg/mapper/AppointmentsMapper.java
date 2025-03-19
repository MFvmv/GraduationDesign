package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Appointments;
import com.hospital.mbg.model.AppointmentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppointmentsMapper {
    long countByExample(AppointmentsExample example);

    int deleteByExample(AppointmentsExample example);

    int deleteByPrimaryKey(Integer AppointmentID);

    int insert(Appointments row);

    int insertSelective(Appointments row);

    List<Appointments> selectByExample(AppointmentsExample example);

    Appointments selectByPrimaryKey(Integer AppointmentID);

    int updateByExampleSelective(@Param("row") Appointments row, @Param("example") AppointmentsExample example);

    int updateByExample(@Param("row") Appointments row, @Param("example") AppointmentsExample example);

    int updateByPrimaryKeySelective(Appointments row);

    int updateByPrimaryKey(Appointments row);
}