package com.hospital.admin.configuration;

import com.hospital.admin.service.RbacPermissionsService;
import com.hospital.mbg.model.RbacPermissions;
import com.hospital.security.component.DynamicSecurityService;
import com.hospital.admin.service.RbacUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * mall-security模块相关配置
 * Created by macro on 2019/11/9.
 */
@Configuration
public class AdminSecurityConfig {

    @Autowired
    private RbacUsersService rbacUsersService;
    @Autowired
    private RbacPermissionsService resourceService;

    //认证，在返回的username的getAuthorities
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> rbacUsersService.loadUserByUsername(username);
    }

    //授权
    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<RbacPermissions> resourceList = resourceService.listAll();
                for (RbacPermissions permission : resourceList) {
                    map.put(permission.getResource(), new org.springframework.security.access.SecurityConfig(permission.getPermission_id() + ":" + permission.getPermission_name()));
                }
                return map;
            }
        };
    }
}
