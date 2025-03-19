package com.hospital.admin.dao;


import com.hospital.mbg.model.RbacPermissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色关系管理自定义Dao
 * Created by macro on 2018/10/8.
 */
@Mapper
public interface RbacUserRoleRelationDao {

    List<RbacPermissions> getRbacPermissionsList(@Param("Id") Integer Id);

}
