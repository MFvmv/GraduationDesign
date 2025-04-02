package com.hospital.admin.bo;

import com.hospital.mbg.model.RbacPermissions;
import com.hospital.mbg.model.RbacUsers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RbacUsersDetails implements UserDetails {
    //后台用户
    private final RbacUsers rbacUsers;
    //拥有资源列表
    private final List<RbacPermissions> rbacPermissionsList;

    public RbacUsersDetails(RbacUsers rbacUsers,List<RbacPermissions> rbacPermissionsList) {
        this.rbacUsers = rbacUsers;
        this.rbacPermissionsList = rbacPermissionsList;
    }

    public RbacUsers getRbacUsers() {
        return rbacUsers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户所拥有的资源
        return rbacPermissionsList.stream()
                .map(permissions ->new SimpleGrantedAuthority(permissions.getPermission_id()+":"+permissions.getPermission_name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return rbacUsers.getPassword();
    }

    @Override
    public String getUsername() {
        return rbacUsers.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return rbacUsers.getEnabled();
    }
}
