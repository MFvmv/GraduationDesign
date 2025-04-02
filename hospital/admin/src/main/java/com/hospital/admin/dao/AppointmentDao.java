package com.hospital.admin.dao;

import com.hospital.admin.dto.AppointmentDetailsResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppointmentDao {
    List<AppointmentDetailsResult> getAppointmentDetailsByUsername(@Param("username") String username);
}
