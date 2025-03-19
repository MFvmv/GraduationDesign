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

import com.hospital.restful.modules.reader.service.RFinancialrecordsDrugconsumptionRelationService;
import com.hospital.mbg.model.FinancialrecordsDrugconsumptionRelation;

import java.util.List;


/**
 * <p>
 * 财务记录与药品消耗关系表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RFinancialrecordsDrugconsumptionRelationController")
@Tag(name = "RFinancialrecordsDrugconsumptionRelationController", description = "财务记录与药品消耗关系表")
@RequestMapping("/RESTful/reader/financialrecordsDrugconsumptionRelation")
public class RFinancialrecordsDrugconsumptionRelationController {

    @Autowired
    private RFinancialrecordsDrugconsumptionRelationService financialrecordsDrugconsumptionRelationService;

    @ApiOperation("按分页返回财务记录与药品消耗关系表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< FinancialrecordsDrugconsumptionRelation>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< FinancialrecordsDrugconsumptionRelation> financialrecordsDrugconsumptionRelationList = financialrecordsDrugconsumptionRelationService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(financialrecordsDrugconsumptionRelationList));
    }

    @ApiOperation("根据ID获取财务记录与药品消耗关系表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< FinancialrecordsDrugconsumptionRelation>> searchByField(
            @RequestParam(value = "field", defaultValue = "ConsumptionID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< FinancialrecordsDrugconsumptionRelation> financialrecordsDrugconsumptionRelationList = financialrecordsDrugconsumptionRelationService.searchByField(field,value,pageSize, pageNum);
        if(financialrecordsDrugconsumptionRelationList != null){
            return CommonResult.success(CommonPage.restPage(financialrecordsDrugconsumptionRelationList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

