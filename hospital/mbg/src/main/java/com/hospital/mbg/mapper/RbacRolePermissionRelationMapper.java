package com.hospital.mbg.mapper;

import com.hospital.mbg.model.RbacRolePermissionRelation;
import com.hospital.mbg.model.RbacRolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbacRolePermissionRelationMapper {
    long countByExample(RbacRolePermissionRelationExample example);

    int deleteByExample(RbacRolePermissionRelationExample example);

    int deleteByPrimaryKey(@Param("role_id") Integer role_id, @Param("permission_id") Integer permission_id);

    int insert(RbacRolePermissionRelation row);

    int insertSelective(RbacRolePermissionRelation row);

    List<RbacRolePermissionRelation> selectByExample(RbacRolePermissionRelationExample example);

    int updateByExampleSelective(@Param("row") RbacRolePermissionRelation row, @Param("example") RbacRolePermissionRelationExample example);

    int updateByExample(@Param("row") RbacRolePermissionRelation row, @Param("example") RbacRolePermissionRelationExample example);
}