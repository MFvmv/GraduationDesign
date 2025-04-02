package com.hospital.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RbacRolesDao {
    Integer selectRoleIdByRoleName(@Param("roleName") String roleName);
}
