package com.hospital.restful.modules.standard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;

import com.hospital.restful.modules.standard.service. SHospitalbedsService;
import com.hospital.mbg.model.Hospitalbeds;

import java.util.List;


/**
 * <p>
 * 病床管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */


@RestController
@Api(tags = "SHospitalbedsController")
@Tag(name = "SHospitalbedsController", description = "病床管理表")
@RequestMapping("/RESTful/standard/hospitalbeds")
public class SHospitalbedsController {

    @Autowired
    private SHospitalbedsService hospitalbedsService;

    @ApiOperation("获取所有病床管理表")
    @GetMapping
    public CommonResult getAll() {
        List<Hospitalbeds> hospitalbedsList = hospitalbedsService.getAll();
        if(hospitalbedsList != null){
            return CommonResult.success(hospitalbedsList,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }

    @ApiOperation("根据ID获取病床管理表")
    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Integer id) {
        Hospitalbeds hospitalbeds = hospitalbedsService.getById(id);
        if(hospitalbeds != null){
            return CommonResult.success(hospitalbeds,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }


    }

    @ApiOperation("创建新的病床管理表的行")
    @PostMapping
    public CommonResult create(@RequestBody Hospitalbeds hospitalbeds) {
        if(hospitalbedsService.create(hospitalbeds)){
            return CommonResult.success( hospitalbeds.getBedID(),"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新病床管理表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Hospitalbeds hospitalbeds) {
        hospitalbeds.setBedID(id);
        if(hospitalbedsService.update(hospitalbeds)){
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

