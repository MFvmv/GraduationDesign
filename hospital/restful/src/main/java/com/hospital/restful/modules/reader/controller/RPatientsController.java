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

import com.hospital.restful.modules.reader.service.RPatientsService;
import com.hospital.mbg.model.Patients;

import java.util.List;


/**
 * <p>
 * 病人信息表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RPatientsController")
@Tag(name = "RPatientsController", description = "病人信息表")
@RequestMapping("/RESTful/reader/patients")
public class RPatientsController {

    @Autowired
    private RPatientsService patientsService;

    @ApiOperation("按分页返回病人信息表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< Patients>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< Patients> patientsList = patientsService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(patientsList));
    }

    @ApiOperation("根据ID获取病人信息表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< Patients>> searchByField(
            @RequestParam(value = "field", defaultValue = "PatientID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< Patients> patientsList = patientsService.searchByField(field,value,pageSize, pageNum);
        if(patientsList != null){
            return CommonResult.success(CommonPage.restPage(patientsList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

