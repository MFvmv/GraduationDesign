package com.hospital.admin.service.impl;


import com.hospital.admin.service.RbacUsersService;
import com.hospital.common.service.RedisService;
import com.hospital.mbg.model.RbacPermissions;
import com.hospital.mbg.model.RbacUsers;
import com.hospital.admin.service.RbacUsersCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 后台用户缓存管理Service实现类
 * Created by macro on 2020/3/13.
 */
@Service
public class RbacUsersCacheServiceImpl implements RbacUsersCacheService {
    @Autowired
    private RbacUsersService usersService;

    @Autowired
    private RedisService redisService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Override
    public RbacUsers getUser(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (RbacUsers) redisService.get(key);
    }

    @Override
    public void setUser(RbacUsers user) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + user.getUsername();
        redisService.set(key, user, REDIS_EXPIRE);
    }

    @Override
    public void delUser(Integer adminId) {
        RbacUsers admin = usersService.getItem(adminId);
        if (admin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public void delRbacPermissionsList(Integer adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.del(key);
    }

    @Override
    public List<RbacPermissions> getRbacPermissionsList(Integer Id) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + Id;
        return (List<RbacPermissions>) redisService.get(key);
    }

    @Override
    public void setRbacPermissionsList(Integer Id, List<RbacPermissions> rbacPermissionsList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + Id;
        redisService.set(key, rbacPermissionsList, REDIS_EXPIRE);
    }
}
