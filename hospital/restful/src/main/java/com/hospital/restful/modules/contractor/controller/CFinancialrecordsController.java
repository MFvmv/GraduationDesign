package com.hospital.restful.modules.contractor.controller;


import com.hospital.externalservice.domain.AliPayParam;
import com.hospital.restful.modules.contractor.dto.CFinancialrecordsParam;
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
import com.hospital.restful.modules.contractor.service. CFinancialrecordsService;

/**
 * <p>
 * 财务管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */


@RestController
@Api(tags = "CFinancialrecordsController")
@Tag(name = "CFinancialrecordsController", description = "财务管理表")
@RequestMapping("/RESTful/contractor/financialrecords")
public class CFinancialrecordsController {

    @Autowired
    private CFinancialrecordsService financialrecordsService;

    @ApiOperation("创建新的财务管理表的行")
    @PostMapping
    public CommonResult create(@Validated @RequestBody CFinancialrecordsParam financialrecords) {
        if(financialrecordsService.create(financialrecords)){
            return CommonResult.success(null,"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新财务管理表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody CFinancialrecordsParam financialrecords) {
        System.out.println("financialrecords:"+financialrecords);
        if(financialrecordsService.update(financialrecords,id)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除财务管理表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(financialrecordsService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }

    @ApiOperation("支付宝相关数据处理")
    @PostMapping("/processAlipayWebPay")
    public CommonResult<String> processAlipayWebPay(@RequestBody AliPayParam aliPayParam) {
        if(financialrecordsService.processAlipayWebPay(aliPayParam)){
            return CommonResult.success(null,"账单已生成成功");
        }else{
            return CommonResult.failed("账单生成失败");
        }
    }
}

