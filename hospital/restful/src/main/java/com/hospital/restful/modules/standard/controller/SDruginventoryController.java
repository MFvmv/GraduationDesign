package com.hospital.restful.modules.standard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hospital.common.api.CommonResult;

import com.hospital.restful.modules.standard.service. SDruginventoryService;
import com.hospital.mbg.model.Druginventory;

import java.util.List;


/**
 * <p>
 * 药品库存管理表 前端控制器
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */


@RestController
@Api(tags = "SDruginventoryController")
@Tag(name = "SDruginventoryController", description = "药品库存管理表")
@RequestMapping("/RESTful/standard/druginventory")
public class SDruginventoryController {

    @Autowired
    private SDruginventoryService druginventoryService;

    @ApiOperation("获取所有药品库存管理表")
    @GetMapping
    public CommonResult getAll() {
        List<Druginventory> druginventoryList = druginventoryService.getAll();
        if(druginventoryList != null){
            return CommonResult.success(druginventoryList,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }

    @ApiOperation("根据ID获取药品库存管理表")
    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Integer id) {
        Druginventory druginventory = druginventoryService.getById(id);
        if(druginventory != null){
            return CommonResult.success(druginventory,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }


    }

    @ApiOperation("创建新的药品库存管理表的行")
    @PostMapping
    public CommonResult create(@RequestBody Druginventory druginventory) {
        if(druginventoryService.create(druginventory)){
            return CommonResult.success( druginventory.getDrugID(),"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("更新药品库存管理表")
    @PutMapping("/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Druginventory druginventory) {
        druginventory.setDrugID(id);
        if(druginventoryService.update(druginventory)){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @ApiOperation("删除药品库存管理表")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Integer id) {
        if(druginventoryService.delete(id)){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }
}

