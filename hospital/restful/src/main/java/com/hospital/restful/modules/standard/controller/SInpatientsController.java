package com.hospital.restful.modules.standard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;

import com.hospital.restful.modules.standard.service. SInpatientsService;
import com.hospital.mbg.model.Inpatients;

import java.util.List;


/**
 * <p>
 * 住院管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */


@RestController
@Api(tags = "SInpatientsController")
@Tag(name = "SInpatientsController", description = "住院管理表")
@RequestMapping("/RESTful/standard/inpatients")
public class SInpatientsController {

    @Autowired
    private SInpatientsService inpatientsService;

    @ApiOperation("获取所有住院管理表")
    @GetMapping
    public CommonResult getAll() {
        List<Inpatients> inpatientsList = inpatientsService.getAll();
        if(inpatientsList != null){
            return CommonResult.success(inpatientsList,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }

    @ApiOperation("根据ID获取住院管理表")
    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Integer id) {
        Inpatients inpatients = inpatientsService.getById(id);
        if(inpatients != null){
            return CommonResult.success(inpatients,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }


    }

    @ApiOperation("创建新的住院管理表的行")
    @PostMapping
    public CommonResult create(@RequestBody Inpatients inpatients) {
        if(inpatientsService.create(inpatients)){
            return CommonResult.success( inpatients.getInpatientID(),"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新住院管理表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Inpatients inpatients) {
        inpatients.setInpatientID(id);
        if(inpatientsService.update(inpatients)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除住院管理表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(inpatientsService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

