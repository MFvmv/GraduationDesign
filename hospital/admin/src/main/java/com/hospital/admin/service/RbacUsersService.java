package com.hospital.admin.service;



import com.hospital.admin.dto.RbacUsersParam;
import com.hospital.mbg.model.RbacPermissions;
import com.hospital.mbg.model.RbacUsers;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface RbacUsersService {

    RbacUsers register(RbacUsersParam RbacUsersParam);

    String login(String username,String password);

    UserDetails loadUserByUsername(String username);

    RbacUsersCacheService getCacheService();

    RbacUsers getUserByUsername(String username);

    List<RbacPermissions> getRbacPermissionsList(Integer Id);

    void logout(String username);

    RbacUsers getItem(Integer id);
}
