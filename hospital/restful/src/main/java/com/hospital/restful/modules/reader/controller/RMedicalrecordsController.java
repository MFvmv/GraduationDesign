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

import com.hospital.restful.modules.reader.service.RMedicalrecordsService;
import com.hospital.mbg.model.Medicalrecords;

import java.util.List;


/**
 * <p>
 * 病历管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RMedicalrecordsController")
@Tag(name = "RMedicalrecordsController", description = "病历管理表")
@RequestMapping("/RESTful/reader/medicalrecords")
public class RMedicalrecordsController {

    @Autowired
    private RMedicalrecordsService medicalrecordsService;

    @ApiOperation("按分页返回病历管理表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< Medicalrecords>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< Medicalrecords> medicalrecordsList = medicalrecordsService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(medicalrecordsList));
    }

    @ApiOperation("根据ID获取病历管理表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< Medicalrecords>> searchByField(
            @RequestParam(value = "field", defaultValue = "RecordID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< Medicalrecords> medicalrecordsList = medicalrecordsService.searchByField(field,value,pageSize, pageNum);
        if(medicalrecordsList != null){
            return CommonResult.success(CommonPage.restPage(medicalrecordsList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

