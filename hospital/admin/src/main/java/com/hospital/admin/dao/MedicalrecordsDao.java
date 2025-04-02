package com.hospital.admin.dao;

import com.hospital.admin.dto.CaseDetailsResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MedicalrecordsDao {
    List<CaseDetailsResult> getMedicalrecordsDetailsByUsername(@Param("username") String name);
}
