package com.hospital.admin.controller;

import com.hospital.admin.dto.RbacUsersParam;
import com.hospital.admin.service.RbacUsersService;
import com.hospital.common.api.CommonResult;
import com.hospital.mbg.model.RbacPermissions;
import com.hospital.mbg.model.RbacUsers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "AdminController")
@Tag(name = "AdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class AdminController {
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private RbacUsersService rbacUsersService;


    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@Validated @RequestBody RbacUsersParam rbacUsersParam) {
        RbacUsers umsAdmin = rbacUsersService.register(rbacUsersParam);
        if (umsAdmin == null) {
            return CommonResult.failed("用户名已存在");
        }
        return login(rbacUsersParam);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@Validated @RequestBody RbacUsersParam rbacUsersParam) {
        String token = rbacUsersService.login(rbacUsersParam.getUsername(), rbacUsersParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult logout(Principal principal) {
        System.out.println("Principal:");
        System.out.println(principal);
        rbacUsersService.logout(principal.getName());
        return CommonResult.success(null);
    }
    @ApiOperation(value = "test")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResult info(){
        List<RbacPermissions> r = rbacUsersService.getCacheService().getRbacPermissionsList(4);
        System.out.println("info:");
        System.out.println(r);
        return CommonResult.success(null);
    }

}

