package com.hospital.restful.modules.standard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;

import com.hospital.restful.modules.standard.service. SFinancialrecordsMedicalrecordsRelationService;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelation;

import java.util.List;


/**
 * <p>
 * 财务记录与病历关系表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */


@RestController
@Api(tags = "SFinancialrecordsMedicalrecordsRelationController")
@Tag(name = "SFinancialrecordsMedicalrecordsRelationController", description = "财务记录与病历关系表")
@RequestMapping("/RESTful/standard/financialrecordsMedicalrecordsRelation")
public class SFinancialrecordsMedicalrecordsRelationController {

    @Autowired
    private SFinancialrecordsMedicalrecordsRelationService financialrecordsMedicalrecordsRelationService;

    @ApiOperation("获取所有财务记录与病历关系表")
    @GetMapping
    public CommonResult getAll() {
        List<FinancialrecordsMedicalrecordsRelation> financialrecordsMedicalrecordsRelationList = financialrecordsMedicalrecordsRelationService.getAll();
        if(financialrecordsMedicalrecordsRelationList != null){
            return CommonResult.success(financialrecordsMedicalrecordsRelationList,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }

    @ApiOperation("根据ID获取财务记录与病历关系表")
    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Integer id) {
        FinancialrecordsMedicalrecordsRelation financialrecordsMedicalrecordsRelation = financialrecordsMedicalrecordsRelationService.getById(id);
        if(financialrecordsMedicalrecordsRelation != null){
            return CommonResult.success(financialrecordsMedicalrecordsRelation,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }


    }

    @ApiOperation("创建新的财务记录与病历关系表的行")
    @PostMapping
    public CommonResult create(@RequestBody FinancialrecordsMedicalrecordsRelation financialrecordsMedicalrecordsRelation) {
        if(financialrecordsMedicalrecordsRelationService.create(financialrecordsMedicalrecordsRelation)){
            return CommonResult.success( financialrecordsMedicalrecordsRelation.getRecordID(),"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新财务记录与病历关系表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody FinancialrecordsMedicalrecordsRelation financialrecordsMedicalrecordsRelation) {
        financialrecordsMedicalrecordsRelation.setRecordID(id);
        if(financialrecordsMedicalrecordsRelationService.update(financialrecordsMedicalrecordsRelation)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除财务记录与病历关系表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(financialrecordsMedicalrecordsRelationService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

