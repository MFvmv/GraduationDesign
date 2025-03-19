package com.hospital.mbg.mapper;

import com.hospital.mbg.model.RbacRoles;
import com.hospital.mbg.model.RbacRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbacRolesMapper {
    long countByExample(RbacRolesExample example);

    int deleteByExample(RbacRolesExample example);

    int deleteByPrimaryKey(Integer role_id);

    int insert(RbacRoles row);

    int insertSelective(RbacRoles row);

    List<RbacRoles> selectByExampleWithBLOBs(RbacRolesExample example);

    List<RbacRoles> selectByExample(RbacRolesExample example);

    RbacRoles selectByPrimaryKey(Integer role_id);

    int updateByExampleSelective(@Param("row") RbacRoles row, @Param("example") RbacRolesExample example);

    int updateByExampleWithBLOBs(@Param("row") RbacRoles row, @Param("example") RbacRolesExample example);

    int updateByExample(@Param("row") RbacRoles row, @Param("example") RbacRolesExample example);

    int updateByPrimaryKeySelective(RbacRoles row);

    int updateByPrimaryKeyWithBLOBs(RbacRoles row);

    int updateByPrimaryKey(RbacRoles row);
}