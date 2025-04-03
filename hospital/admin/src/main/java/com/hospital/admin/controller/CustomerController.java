package com.hospital.admin.controller;

import com.hospital.admin.bo.RbacUsersDetails;
import com.hospital.admin.dto.*;
import com.hospital.admin.service.CustomerService;
import com.hospital.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "CustomerController")
@Tag(name = "CustomerController", description = "前端客户端接口")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "客户端用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult register(@Validated @RequestBody RbacUsersParam rbacUsersParam) {
        String token = customerService.register(rbacUsersParam);
        if (token == null) {
            return CommonResult.failed("注册失败");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "客户端登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@Validated @RequestBody RbacUsersParam rbacUsersParam) {
        String token = customerService.login(rbacUsersParam.getUsername(), rbacUsersParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "客户端登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public CommonResult logout(@ApiIgnore Principal principal) {
        System.out.println("Principal:");
        System.out.println(principal);
        customerService.logout(principal.getName());
        return CommonResult.success(null);
    }

    @ApiOperation(value = "客户端用户信息功能")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResult<UserInfoResult> info(@ApiIgnore Principal principal){
        System.out.println("username:"+principal.getName());
        UserInfoResult userInfoResult = customerService.info(principal.getName());
        System.out.println(userInfoResult);
        return CommonResult.success(userInfoResult);
    }

    @ApiOperation(value = "用户与病人绑定")
    @RequestMapping(value = "/bindPatient", method = RequestMethod.POST)
    public CommonResult bindPatient(@RequestParam String id_card_number,@ApiIgnore Principal principal) {
        return customerService.bindPatient(principal,id_card_number);
    }

    @ApiOperation(value = "获得预约登录账号预约列表")
    @RequestMapping(value = "/appointmentList", method = RequestMethod.GET)
    public CommonResult<List<AppointmentDetailsResult>> getAppointmentList(@ApiIgnore Principal principal){
        List<AppointmentDetailsResult> list = customerService.getAppointmentList(principal.getName());
        return CommonResult.success(list);
    }

    @ApiOperation(value = "添加预约")
    @RequestMapping(value = "/addAppointment", method = RequestMethod.POST)
    public CommonResult addAppointment(@ApiIgnore Principal principal,@RequestBody AddAppointmentParam addAppointmentParam){
        return customerService.addAppointment(principal,addAppointmentParam);
    }

    @ApiOperation(value = "获得医生的信息")
    @RequestMapping(value = "/getDoctorsInfo", method = RequestMethod.GET)
    public CommonResult getDoctorsInfo(){
        List<DoctorsInfoResult> list = customerService.getDoctorsInfo();
        if(list == null) return  CommonResult.failed("获取医生信息失败");
        return CommonResult.success(list,"获取医生信息成功");
    }

    @ApiOperation(value = "客户端用户信息功能")
    @RequestMapping(value = "/caseList", method = RequestMethod.GET)
    public CommonResult<List<CaseDetailsResult>> getCaseList(@ApiIgnore Principal principal){
        List<CaseDetailsResult> list = customerService.getCaseList(principal.getName());
        return CommonResult.success(list);
    }


}



