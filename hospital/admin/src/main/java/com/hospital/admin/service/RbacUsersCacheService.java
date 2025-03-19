package com.hospital.admin.service;


import com.hospital.mbg.model.RbacPermissions;
import com.hospital.mbg.model.RbacUsers;

import java.util.List;

/**
 * 后台用户缓存管理Service
 * Created by macro on 2020/3/13.
 */
public interface RbacUsersCacheService {
    List<RbacPermissions> getRbacPermissionsList(Integer Id);

    void setRbacPermissionsList(Integer Id, List<RbacPermissions> rbacPermissionsList);

    RbacUsers getUser(String username);

    void setUser(RbacUsers user);

    void delRbacPermissionsList(Integer adminId);

    void delUser(Integer adminId);
}
