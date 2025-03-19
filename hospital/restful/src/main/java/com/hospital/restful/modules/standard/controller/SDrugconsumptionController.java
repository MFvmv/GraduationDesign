package com.hospital.restful.modules.standard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;

import com.hospital.restful.modules.standard.service. SDrugconsumptionService;
import com.hospital.mbg.model.Drugconsumption;

import java.util.List;


/**
 * <p>
 * 药品消耗记录表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */


@RestController
@Api(tags = "SDrugconsumptionController")
@Tag(name = "SDrugconsumptionController", description = "药品消耗记录表")
@RequestMapping("/RESTful/standard/drugconsumption")
public class SDrugconsumptionController {

    @Autowired
    private SDrugconsumptionService drugconsumptionService;

    @ApiOperation("获取所有药品消耗记录表")
    @GetMapping
    public CommonResult getAll() {
        List<Drugconsumption> drugconsumptionList = drugconsumptionService.getAll();
        if(drugconsumptionList != null){
            return CommonResult.success(drugconsumptionList,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }

    @ApiOperation("根据ID获取药品消耗记录表")
    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Integer id) {
        Drugconsumption drugconsumption = drugconsumptionService.getById(id);
        if(drugconsumption != null){
            return CommonResult.success(drugconsumption,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }


    }

    @ApiOperation("创建新的药品消耗记录表的行")
    @PostMapping
    public CommonResult create(@RequestBody Drugconsumption drugconsumption) {
        if(drugconsumptionService.create(drugconsumption)){
            return CommonResult.success( drugconsumption.getConsumptionID(),"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新药品消耗记录表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Drugconsumption drugconsumption) {
        drugconsumption.setConsumptionID(id);
        if(drugconsumptionService.update(drugconsumption)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除药品消耗记录表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(drugconsumptionService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

