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

import com.hospital.restful.modules.reader.service.RDruginventoryService;
import com.hospital.mbg.model.Druginventory;

import java.util.List;


/**
 * <p>
 * 药品库存管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */


@RestController
@Api(tags = "RDruginventoryController")
@Tag(name = "RDruginventoryController", description = "药品库存管理表")
@RequestMapping("/RESTful/reader/druginventory")
public class RDruginventoryController {

    @Autowired
    private RDruginventoryService druginventoryService;

    @ApiOperation("按分页返回药品库存管理表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage< Druginventory>> list(
        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List< Druginventory> druginventoryList = druginventoryService.list(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(druginventoryList));
    }

    @ApiOperation("根据ID获取药品库存管理表返回分页")
    @GetMapping("/searchByField")
    public CommonResult<CommonPage< Druginventory>> searchByField(
            @RequestParam(value = "field", defaultValue = "DrugID") String field,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
        ) {
        List< Druginventory> druginventoryList = druginventoryService.searchByField(field,value,pageSize, pageNum);
        if(druginventoryList != null){
            return CommonResult.success(CommonPage.restPage(druginventoryList),"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}

