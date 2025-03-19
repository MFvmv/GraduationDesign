package com.hospital.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.hospital.admin.bo.RbacUsersDetails;
import com.hospital.admin.dto.RbacUsersParam;
import com.hospital.admin.service.RbacUsersCacheService;
import com.hospital.admin.service.RbacUsersService;
import com.hospital.common.exception.Asserts;
import com.hospital.admin.dao.RbacUserRoleRelationDao;
import com.hospital.mbg.mapper.RbacUsersMapper;
import com.hospital.mbg.model.RbacPermissions;
import com.hospital.mbg.model.RbacUsers;
import com.hospital.mbg.model.RbacUsersExample;
import com.hospital.security.util.JwtTokenUtil;
import com.hospital.security.util.SpringUtil;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RbacUsersServiceImpl implements RbacUsersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RbacUsersServiceImpl.class);

    @Autowired
    private RbacUsersMapper rbacUsersMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RbacUserRoleRelationDao rbacUserRoleRelationDao;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public RbacUsers register(RbacUsersParam umsAdminParam) {
        RbacUsers rbacUsers = new RbacUsers();
        BeanUtils.copyProperties(umsAdminParam, rbacUsers);
        rbacUsers.setCreate_time(new Date());
        rbacUsers.setEnabled(true);
        //查询是否有相同用户名的用户
        RbacUsersExample example = new RbacUsersExample();
        example.createCriteria().andUsernameEqualTo(rbacUsers.getUsername());
        List<RbacUsers> umsAdminList = rbacUsersMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(rbacUsers.getPassword());
        rbacUsers.setPassword(encodePassword);
        rbacUsersMapper.insert(rbacUsers);
        return rbacUsers;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            if(!userDetails.isEnabled()){
                Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
//            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        RbacUsers users = getUserByUsername(username);
        if (users != null) {
            List<RbacPermissions> resourceList = getRbacPermissionsList(users.getUser_id());
            return new RbacUsersDetails(users,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public List<RbacPermissions> getRbacPermissionsList(Integer Id) {
        //先从缓存中获取数据
        List<RbacPermissions> resourceList = getCacheService().getRbacPermissionsList(Id);
        if(CollUtil.isNotEmpty(resourceList)){
            return  resourceList;
        }
        //缓存中没有从数据库中获取
        resourceList = rbacUserRoleRelationDao.getRbacPermissionsList(Id);
        if(CollUtil.isNotEmpty(resourceList)){
            //将数据库中的数据存入缓存中
//            System.out.println("设置权限: getCacheService().setRbacPermissionsList(Id,resourceList);");
            getCacheService().setRbacPermissionsList(Id,resourceList);
        }
        return resourceList;
    }

    @Override
    public RbacUsersCacheService getCacheService() {
        return SpringUtil.getBean(RbacUsersCacheService.class);
    }

    @Override
    public RbacUsers getUserByUsername(String username) {
        //先从缓存中获取数据
        RbacUsers user = getCacheService().getUser(username);
        if (user != null) return user;
        //缓存中没有从数据库中获取
        RbacUsersExample example = new RbacUsersExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<RbacUsers> rbacUsersList = rbacUsersMapper.selectByExample(example);
        if (rbacUsersList != null && rbacUsersList.size() > 0) {
            user = rbacUsersList.get(0);
            //将数据库中的数据存入缓存中
            getCacheService().setUser(user);
            return user;
        }
        return null;
    }

    @Override
    public RbacUsers getItem(Integer id) {
        return rbacUsersMapper.selectByPrimaryKey(id);
    }


    @Override
    public void logout(String username) {
        //清空缓存中的用户相关数据
        RbacUsers user = getCacheService().getUser(username);
        getCacheService().delUser(user.getUser_id());
        getCacheService().delRbacPermissionsList(user.getUser_id());
    }

}
