package com.hospital.restful.modules.reader.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;
import com.hospital.common.api.CommonPage;

import com.hospital.restful.modules.reader.service.RAppointmentsService;
import com.hospital.mbg.model.Appointments;

import java.util.List;


/**
 * <p>
 * 挂号与预约表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RAppointmentsController")
@Tag(name = "RAppointmentsController", description = "挂号与预约表")
@RequestMapping("/RESTful/reader/appointments")
public class RAppointmentsController {

    @Autowired
    private RAppointmentsService appointmentsService;

    @ApiOperation("按分页返回挂号与预约表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< Appointments>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< Appointments> appointmentsList = appointmentsService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(appointmentsList));
    }

    @ApiOperation("根据ID获取挂号与预约表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< Appointments>> searchByField(
            @RequestParam(value = "field", defaultValue = "AppointmentID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< Appointments> appointmentsList = appointmentsService.searchByField(field,value,pageSize, pageNum);
        if(appointmentsList != null){
            return CommonResult.success(CommonPage.restPage(appointmentsList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

