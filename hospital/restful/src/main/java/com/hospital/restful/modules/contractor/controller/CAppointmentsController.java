package com.hospital.restful.modules.contractor.controller;

import com.hospital.restful.modules.contractor.domain.CAppointmentsParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;
import com.hospital.restful.modules.contractor.service. CAppointmentsService;

/**
 * <p>
 * 挂号与预约表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */


@RestController
@Api(tags = "CAppointmentsController")
@Tag(name = "CAppointmentsController", description = "挂号与预约表")
@RequestMapping("/RESTful/contractor/appointments")
public class CAppointmentsController {

    @Autowired
    private CAppointmentsService appointmentsService;

    @ApiOperation("创建新的挂号与预约表的行")
    @PostMapping
    public CommonResult create(@Validated @RequestBody CAppointmentsParam appointments) {
        if(appointmentsService.create(appointments)){
            return CommonResult.success(null,"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新挂号与预约表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody CAppointmentsParam appointments) {
        if(appointmentsService.update(appointments,id)){
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

