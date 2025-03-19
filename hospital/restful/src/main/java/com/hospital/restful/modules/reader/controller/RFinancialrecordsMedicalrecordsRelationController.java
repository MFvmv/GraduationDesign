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

import com.hospital.restful.modules.reader.service.RFinancialrecordsMedicalrecordsRelationService;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelation;

import java.util.List;


/**
 * <p>
 * 财务记录与病历关系表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RFinancialrecordsMedicalrecordsRelationController")
@Tag(name = "RFinancialrecordsMedicalrecordsRelationController", description = "财务记录与病历关系表")
@RequestMapping("/RESTful/reader/financialrecordsMedicalrecordsRelation")
public class RFinancialrecordsMedicalrecordsRelationController {

    @Autowired
    private RFinancialrecordsMedicalrecordsRelationService financialrecordsMedicalrecordsRelationService;

    @ApiOperation("按分页返回财务记录与病历关系表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< FinancialrecordsMedicalrecordsRelation>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< FinancialrecordsMedicalrecordsRelation> financialrecordsMedicalrecordsRelationList = financialrecordsMedicalrecordsRelationService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(financialrecordsMedicalrecordsRelationList));
    }

    @ApiOperation("根据ID获取财务记录与病历关系表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< FinancialrecordsMedicalrecordsRelation>> searchByField(
            @RequestParam(value = "field", defaultValue = "RecordID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< FinancialrecordsMedicalrecordsRelation> financialrecordsMedicalrecordsRelationList = financialrecordsMedicalrecordsRelationService.searchByField(field,value,pageSize, pageNum);
        if(financialrecordsMedicalrecordsRelationList != null){
            return CommonResult.success(CommonPage.restPage(financialrecordsMedicalrecordsRelationList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

