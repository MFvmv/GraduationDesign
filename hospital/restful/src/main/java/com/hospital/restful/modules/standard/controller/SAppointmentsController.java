package com.hospital.restful.modules.standard.controller;

import com.hospital.mbg.model.Appointments;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;

import com.hospital.restful.modules.standard.service. SAppointmentsService;


import java.util.List;


/**
 * <p>
 * 挂号与预约表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */


@RestController
@Api(tags = "SAppointmentsController")
@Tag(name = "SAppointmentsController", description = "挂号与预约表")
@RequestMapping("/RESTful/standard/appointments")
public class SAppointmentsController {

    @Autowired
    private SAppointmentsService appointmentsService;

    @ApiOperation("获取所有挂号与预约表")
    @GetMapping
    public CommonResult getAll() {
        List<Appointments> appointmentsList = appointmentsService.getAll();
        if(appointmentsList != null){
            return CommonResult.success(appointmentsList,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }

    @ApiOperation("根据ID获取挂号与预约表")
    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Integer id) {
        Appointments appointments = appointmentsService.getById(id);
        if(appointments != null){
            return CommonResult.success(appointments,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }


    }

    @ApiOperation("创建新的挂号与预约表的行")
    @PostMapping
    public CommonResult create(@RequestBody Appointments appointments) {
        if(appointmentsService.create(appointments)){
            return CommonResult.success( appointments.getAppointmentID(),"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新挂号与预约表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Appointments appointments) {
        appointments.setAppointmentID(id);
        if(appointmentsService.update(appointments)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除挂号与预约表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(appointmentsService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

