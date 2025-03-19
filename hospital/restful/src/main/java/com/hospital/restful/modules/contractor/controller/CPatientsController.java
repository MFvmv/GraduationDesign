package com.hospital.restful.modules.contractor.controller;

import com.hospital.restful.modules.contractor.dto.CPatientsParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;
import com.hospital.restful.modules.contractor.service. CPatientsService;

/**
 * <p>
 * 病人信息表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */


@RestController
@Api(tags = "CPatientsController")
@Tag(name = "CPatientsController", description = "病人信息表")
@RequestMapping("/RESTful/contractor/patients")
public class CPatientsController {

    @Autowired
    private CPatientsService patientsService;

    @ApiOperation("创建新的病人信息表的行")
    @PostMapping
    public CommonResult create(@Validated @RequestBody CPatientsParam patients) {
        if(patientsService.create(patients)){
            return CommonResult.success(null,"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新病人信息表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody CPatientsParam patients) {
        if(patientsService.update(patients,id)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除病人信息表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(patientsService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

