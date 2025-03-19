package com.hospital.mbg.mapper;

import com.hospital.mbg.model.RbacUserRoleRelation;
import com.hospital.mbg.model.RbacUserRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbacUserRoleRelationMapper {
    long countByExample(RbacUserRoleRelationExample example);

    int deleteByExample(RbacUserRoleRelationExample example);

    int deleteByPrimaryKey(@Param("user_id") Integer user_id, @Param("role_id") Integer role_id);

    int insert(RbacUserRoleRelation row);

    int insertSelective(RbacUserRoleRelation row);

    List<RbacUserRoleRelation> selectByExample(RbacUserRoleRelationExample example);

    int updateByExampleSelective(@Param("row") RbacUserRoleRelation row, @Param("example") RbacUserRoleRelationExample example);

    int updateByExample(@Param("row") RbacUserRoleRelation row, @Param("example") RbacUserRoleRelationExample example);
}