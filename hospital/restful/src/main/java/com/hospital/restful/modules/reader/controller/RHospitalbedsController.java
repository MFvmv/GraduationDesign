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

import com.hospital.restful.modules.reader.service.RHospitalbedsService;
import com.hospital.mbg.model.Hospitalbeds;

import java.util.List;


/**
 * <p>
 * 病床管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RHospitalbedsController")
@Tag(name = "RHospitalbedsController", description = "病床管理表")
@RequestMapping("/RESTful/reader/hospitalbeds")
public class RHospitalbedsController {

    @Autowired
    private RHospitalbedsService hospitalbedsService;

    @ApiOperation("按分页返回病床管理表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< Hospitalbeds>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< Hospitalbeds> hospitalbedsList = hospitalbedsService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(hospitalbedsList));
    }

    @ApiOperation("根据ID获取病床管理表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< Hospitalbeds>> searchByField(
            @RequestParam(value = "field", defaultValue = "BedID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< Hospitalbeds> hospitalbedsList = hospitalbedsService.searchByField(field,value,pageSize, pageNum);
        if(hospitalbedsList != null){
            return CommonResult.success(CommonPage.restPage(hospitalbedsList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

