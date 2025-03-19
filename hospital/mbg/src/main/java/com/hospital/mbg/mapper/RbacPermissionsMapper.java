package com.hospital.mbg.mapper;

import com.hospital.mbg.model.RbacPermissions;
import com.hospital.mbg.model.RbacPermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbacPermissionsMapper {
    long countByExample(RbacPermissionsExample example);

    int deleteByExample(RbacPermissionsExample example);

    int deleteByPrimaryKey(Integer permission_id);

    int insert(RbacPermissions row);

    int insertSelective(RbacPermissions row);

    List<RbacPermissions> selectByExampleWithBLOBs(RbacPermissionsExample example);

    List<RbacPermissions> selectByExample(RbacPermissionsExample example);

    RbacPermissions selectByPrimaryKey(Integer permission_id);

    int updateByExampleSelective(@Param("row") RbacPermissions row, @Param("example") RbacPermissionsExample example);

    int updateByExampleWithBLOBs(@Param("row") RbacPermissions row, @Param("example") RbacPermissionsExample example);

    int updateByExample(@Param("row") RbacPermissions row, @Param("example") RbacPermissionsExample example);

    int updateByPrimaryKeySelective(RbacPermissions row);

    int updateByPrimaryKeyWithBLOBs(RbacPermissions row);

    int updateByPrimaryKey(RbacPermissions row);
}