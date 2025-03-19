package com.hospital.restful.modules.standard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;

import com.hospital.restful.modules.standard.service. SPatientsService;
import com.hospital.mbg.model.Patients;

import java.util.List;


/**
 * <p>
 * 病人信息表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */


@RestController
@Api(tags = "SPatientsController")
@Tag(name = "SPatientsController", description = "病人信息表")
@RequestMapping("/RESTful/standard/patients")
public class SPatientsController {

    @Autowired
    private SPatientsService patientsService;

    @ApiOperation("获取所有病人信息表")
    @GetMapping
    public CommonResult getAll() {
        List<Patients> patientsList = patientsService.getAll();
        if(patientsList != null){
            return CommonResult.success(patientsList,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }

    @ApiOperation("根据ID获取病人信息表")
    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Integer id) {
        Patients patients = patientsService.getById(id);
        if(patients != null){
            return CommonResult.success(patients,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }


    }

    @ApiOperation("创建新的病人信息表的行")
    @PostMapping
    public CommonResult create(@RequestBody Patients patients) {
        if(patientsService.create(patients)){
            return CommonResult.success( patients.getPatientID(),"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新病人信息表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Patients patients) {
        patients.setPatientID(id);
        if(patientsService.update(patients)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除病人信息表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(patientsService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

