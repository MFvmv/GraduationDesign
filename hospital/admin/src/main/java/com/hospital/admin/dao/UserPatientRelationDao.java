package com.hospital.admin.dao;

import com.hospital.admin.dto.UserInfoResult;
import org.apache.ibatis.annotations.Param;

public interface UserPatientRelationDao {
    void getInfo(UserInfoResult userInfoResult);
}
