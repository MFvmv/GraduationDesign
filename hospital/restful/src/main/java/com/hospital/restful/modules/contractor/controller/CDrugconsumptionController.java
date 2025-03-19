package com.hospital.restful.modules.contractor.controller;

import com.hospital.restful.modules.contractor.domain.CCDrugconsumptionMixParam;
import com.hospital.restful.modules.contractor.domain.CUDrugconsumptionMixParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;
import com.hospital.restful.modules.contractor.service. CDrugconsumptionService;

/**
 * <p>
 * 药品消耗记录表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */


@RestController
@Api(tags = "CDrugconsumptionController")
@Tag(name = "CDrugconsumptionController", description = "药品消耗记录表")
@RequestMapping("/RESTful/contractor/drugconsumption")
public class CDrugconsumptionController {

    @Autowired
    private CDrugconsumptionService drugconsumptionService;

    @ApiOperation("创建新的药品消耗记录表的行,")
    @PostMapping
    public CommonResult create(@Validated @RequestBody CCDrugconsumptionMixParam drugconsumptionMixParam) {
        if((drugconsumptionMixParam.getFinancialrecordsParam() == null &&
                drugconsumptionMixParam.getTransactionID() == null) ?
                drugconsumptionService.create(drugconsumptionMixParam.getDrugconsumptionParam()):
                drugconsumptionService.create(drugconsumptionMixParam)
        ){
            return CommonResult.success(null,"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新药品消耗记录表")
    @PutMapping("/{id}")
    public CommonResult update(@RequestBody CUDrugconsumptionMixParam drugconsumptionMixParam,
                               @PathVariable Integer id) {
        if(drugconsumptionMixParam.getTransactionID() == null?
                drugconsumptionService.update(drugconsumptionMixParam.getDrugconsumptionParam(),id):
                drugconsumptionService.update(drugconsumptionMixParam,id)
        ){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除药品消耗记录表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(drugconsumptionService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

