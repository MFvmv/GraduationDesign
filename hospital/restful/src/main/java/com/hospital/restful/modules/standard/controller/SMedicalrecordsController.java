package com.hospital.restful.modules.standard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;

import com.hospital.restful.modules.standard.service. SMedicalrecordsService;
import com.hospital.mbg.model.Medicalrecords;

import java.util.List;


/**
 * <p>
 * 病历管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */


@RestController
@Api(tags = "SMedicalrecordsController")
@Tag(name = "SMedicalrecordsController", description = "病历管理表")
@RequestMapping("/RESTful/standard/medicalrecords")
public class SMedicalrecordsController {

    @Autowired
    private SMedicalrecordsService medicalrecordsService;

    @ApiOperation("获取所有病历管理表")
    @GetMapping
    public CommonResult getAll() {
        List<Medicalrecords> medicalrecordsList = medicalrecordsService.getAll();
        if(medicalrecordsList != null){
            return CommonResult.success(medicalrecordsList,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }

    @ApiOperation("根据ID获取病历管理表")
    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Integer id) {
        Medicalrecords medicalrecords = medicalrecordsService.getById(id);
        if(medicalrecords != null){
            return CommonResult.success(medicalrecords,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }


    }

    @ApiOperation("创建新的病历管理表的行")
    @PostMapping
    public CommonResult create(@RequestBody Medicalrecords medicalrecords) {
        if(medicalrecordsService.create(medicalrecords)){
            return CommonResult.success( medicalrecords.getRecordID(),"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新病历管理表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Medicalrecords medicalrecords) {
        medicalrecords.setRecordID(id);
        if(medicalrecordsService.update(medicalrecords)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除病历管理表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(medicalrecordsService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

