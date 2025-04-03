package com.hospital.admin.dao;

import com.hospital.admin.dto.DoctorsInfoResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorsDao {

    List<DoctorsInfoResult> getInfo();
}
