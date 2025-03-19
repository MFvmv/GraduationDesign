package com.hospital.restful.modules.standard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;

import com.hospital.restful.modules.standard.service. SFinancialrecordsService;
import com.hospital.mbg.model.Financialrecords;

import java.util.List;


/**
 * <p>
 * 财务管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */


@RestController
@Api(tags = "SFinancialrecordsController")
@Tag(name = "SFinancialrecordsController", description = "财务管理表")
@RequestMapping("/RESTful/standard/financialrecords")
public class SFinancialrecordsController {

    @Autowired
    private SFinancialrecordsService financialrecordsService;

    @ApiOperation("获取所有财务管理表")
    @GetMapping
    public CommonResult getAll() {
        List<Financialrecords> financialrecordsList = financialrecordsService.getAll();
        if(financialrecordsList != null){
            return CommonResult.success(financialrecordsList,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }

    @ApiOperation("根据ID获取财务管理表")
    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Integer id) {
        Financialrecords financialrecords = financialrecordsService.getById(id);
        if(financialrecords != null){
            return CommonResult.success(financialrecords,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }


    }

    @ApiOperation("创建新的财务管理表的行")
    @PostMapping
    public CommonResult create(@RequestBody Financialrecords financialrecords) {
        if(financialrecordsService.create(financialrecords)){
            return CommonResult.success( financialrecords.getTransactionID(),"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新财务管理表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Financialrecords financialrecords) {
        financialrecords.setTransactionID(id);
        if(financialrecordsService.update(financialrecords)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除财务管理表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(financialrecordsService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

