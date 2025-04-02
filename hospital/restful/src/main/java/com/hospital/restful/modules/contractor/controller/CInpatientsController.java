package com.hospital.restful.modules.contractor.controller;

import com.hospital.restful.modules.contractor.dto.CCInpatientsMixParam;
import com.hospital.restful.modules.contractor.dto.CUInpatientsMixParam;
import com.hospital.restful.modules.contractor.service.CHospitalbedsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;
import com.hospital.restful.modules.contractor.service. CInpatientsService;

/**
 * <p>
 * 住院管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */


@RestController
@Api(tags = "CInpatientsController")
@Tag(name = "CInpatientsController", description = "住院管理表")
@RequestMapping("/RESTful/contractor/inpatients")
public class CInpatientsController {

    @Autowired
    private CInpatientsService inpatientsService;

    @Autowired
    private CHospitalbedsService hospitalbedsService;

    @ApiOperation("创建新的住院管理表的行")
    @PostMapping
    public CommonResult create(@Validated @RequestBody CCInpatientsMixParam inpatientsMixParam) {
        if(!hospitalbedsService.hasHospitalbeds(
                inpatientsMixParam.getInpatientsParam().getRoomNumber(),
                inpatientsMixParam.getInpatientsParam().getBedNumber()
        )){
            return CommonResult.failed("添加失败,床号或房号不存在");
        }
        if((inpatientsMixParam.getFinancialrecordsParam() == null &&
                inpatientsMixParam.getTransactionID() == null) ?
                inpatientsService.create(inpatientsMixParam.getInpatientsParam()):
                inpatientsService.create(inpatientsMixParam)
        ){
            return CommonResult.success(null,"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新住院管理表")
    @PutMapping("/{id}")
    public CommonResult update(@RequestBody CUInpatientsMixParam inpatientsMixParam,
                               @PathVariable Integer id) {
        if(!hospitalbedsService.hasHospitalbeds(
                inpatientsMixParam.getInpatientsParam().getRoomNumber(),
                inpatientsMixParam.getInpatientsParam().getBedNumber()
        )){
            return CommonResult.failed("更新失败,床号或房号不存在");
        }
        if(inpatientsMixParam.getTransactionID() == null ?
                inpatientsService.update(inpatientsMixParam.getInpatientsParam(),id):
                inpatientsService.update(inpatientsMixParam,id)
        ){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除住院管理表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(inpatientsService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

