package com.hospital.restful.modules.contractor.controller;

import com.hospital.restful.modules.contractor.dto.CCMedicalrecordsMixParam;
import com.hospital.restful.modules.contractor.dto.CUMedicalrecordsMixParam;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;
import com.hospital.restful.modules.contractor.service. CMedicalrecordsService;

/**
 * <p>
 * 病历管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */


@RestController
@Api(tags = "CMedicalrecordsController")
@Tag(name = "CMedicalrecordsController", description = "病历管理表")
@RequestMapping("/RESTful/contractor/medicalrecords")
public class CMedicalrecordsController {

    @Autowired
    private CMedicalrecordsService medicalrecordsService;

    @ApiOperation("创建新的病历管理表的行")
    @PostMapping
    public CommonResult create(@Validated @RequestBody CCMedicalrecordsMixParam medicalrecordsMixParam) {
        if((medicalrecordsMixParam.getFinancialrecordsParam() == null &&
                medicalrecordsMixParam.getTransactionID() == null)?
                medicalrecordsService.create(medicalrecordsMixParam.getMedicalrecordsParam()):
                medicalrecordsService.create(medicalrecordsMixParam)
        ){
            return CommonResult.success(null,"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新病历管理表")
    @PutMapping("/{id}")
    public CommonResult update(@RequestBody CUMedicalrecordsMixParam medicalrecordsMixParam,
                               @PathVariable Integer id) {
        if(medicalrecordsMixParam.getTransactionID() == null ?
                medicalrecordsService.update(medicalrecordsMixParam.getMedicalrecordsParam(),id):
                medicalrecordsService.update(medicalrecordsMixParam,id)
        ){
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

    @ApiOperation("删除病历管理表的影像数据")
    @DeleteMapping("/deleteImage/{id}")
    public CommonResult deleteImage(
            @ApiParam(value = "病历ID", required = true) @PathVariable Integer id,
            @ApiParam(value = "影像JSON数据", required = true) @RequestBody String value,
            @ApiParam(value = "OSS存储路径", required = true) @RequestParam String ossPath
         ) {
        if(medicalrecordsService.deleteImage(id,value,ossPath)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

