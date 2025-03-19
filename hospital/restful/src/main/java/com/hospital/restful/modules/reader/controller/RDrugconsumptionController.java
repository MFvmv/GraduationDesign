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

import com.hospital.restful.modules.reader.service.RDrugconsumptionService;
import com.hospital.mbg.model.Drugconsumption;

import java.util.List;


/**
 * <p>
 * 药品消耗记录表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RDrugconsumptionController")
@Tag(name = "RDrugconsumptionController", description = "药品消耗记录表")
@RequestMapping("/RESTful/reader/drugconsumption")
public class RDrugconsumptionController {

    @Autowired
    private RDrugconsumptionService drugconsumptionService;

    @ApiOperation("按分页返回药品消耗记录表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< Drugconsumption>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< Drugconsumption> drugconsumptionList = drugconsumptionService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(drugconsumptionList));
    }

    @ApiOperation("根据ID获取药品消耗记录表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< Drugconsumption>> searchByField(
            @RequestParam(value = "field", defaultValue = "ConsumptionID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< Drugconsumption> drugconsumptionList = drugconsumptionService.searchByField(field,value,pageSize, pageNum);
        if(drugconsumptionList != null){
            return CommonResult.success(CommonPage.restPage(drugconsumptionList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

