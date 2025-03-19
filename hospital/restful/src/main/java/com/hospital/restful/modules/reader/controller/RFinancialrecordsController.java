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

import com.hospital.restful.modules.reader.service.RFinancialrecordsService;
import com.hospital.mbg.model.Financialrecords;

import java.util.List;


/**
 * <p>
 * 财务管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RFinancialrecordsController")
@Tag(name = "RFinancialrecordsController", description = "财务管理表")
@RequestMapping("/RESTful/reader/financialrecords")
public class RFinancialrecordsController {

    @Autowired
    private RFinancialrecordsService financialrecordsService;

    @ApiOperation("按分页返回财务管理表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< Financialrecords>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< Financialrecords> financialrecordsList = financialrecordsService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(financialrecordsList));
    }

    @ApiOperation("根据ID获取财务管理表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< Financialrecords>> searchByField(
            @RequestParam(value = "field", defaultValue = "TransactionID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< Financialrecords> financialrecordsList = financialrecordsService.searchByField(field,value,pageSize, pageNum);
        if(financialrecordsList != null){
            return CommonResult.success(CommonPage.restPage(financialrecordsList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

