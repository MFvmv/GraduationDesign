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

import com.hospital.restful.modules.reader.service.RInpatientsService;
import com.hospital.mbg.model.Inpatients;

import java.util.List;


/**
 * <p>
 * 住院管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RInpatientsController")
@Tag(name = "RInpatientsController", description = "住院管理表")
@RequestMapping("/RESTful/reader/inpatients")
public class RInpatientsController {

    @Autowired
    private RInpatientsService inpatientsService;

    @ApiOperation("按分页返回住院管理表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< Inpatients>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< Inpatients> inpatientsList = inpatientsService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(inpatientsList));
    }

    @ApiOperation("根据ID获取住院管理表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< Inpatients>> searchByField(
            @RequestParam(value = "field", defaultValue = "InpatientID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< Inpatients> inpatientsList = inpatientsService.searchByField(field,value,pageSize, pageNum);
        if(inpatientsList != null){
            return CommonResult.success(CommonPage.restPage(inpatientsList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

