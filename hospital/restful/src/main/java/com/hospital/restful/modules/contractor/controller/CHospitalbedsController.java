package com.hospital.restful.modules.contractor.controller;

import com.hospital.restful.modules.contractor.dto.CHospitalbedsParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;
import com.hospital.restful.modules.contractor.service. CHospitalbedsService;

/**
 * <p>
 * 病床管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */


@RestController
@Api(tags = "CHospitalbedsController")
@Tag(name = "CHospitalbedsController", description = "病床管理表")
@RequestMapping("/RESTful/contractor/hospitalbeds")
public class CHospitalbedsController {

    @Autowired
    private CHospitalbedsService hospitalbedsService;

    @ApiOperation("创建新的病床管理表的行")
    @PostMapping
    public CommonResult create(@Validated @RequestBody CHospitalbedsParam hospitalbeds) {
        if(hospitalbedsService.create(hospitalbeds)){
            return CommonResult.success(null,"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新病床管理表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody CHospitalbedsParam hospitalbeds) {
        if(hospitalbedsService.update(hospitalbeds,id)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除病床管理表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(hospitalbedsService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

