package com.hospital.search.controller;


import com.hospital.common.api.CommonPage;
import com.hospital.common.api.CommonResult;
import com.hospital.search.domain.EsPatients;
import com.hospital.search.service.EsPatientsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(tags = "EsPatientsController")
@Tag(name = "EsPatientsController",description = "搜索病人管理")
@RequestMapping("/esPatients")
public class EsPatientsController {
    @Autowired
    private EsPatientsService esPatientsService;

    @ApiOperation(value = "导入所有数据库中病人信息到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Long> importAllList() {
        long count = esPatientsService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "删除所有ES中病人信息")
    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Long> deleteAll() {
        long count = esPatientsService.deleteAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsPatients>> search(@RequestParam(required = false) String keyword,
                                                       @RequestParam(required = false) String field,
                                                       @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        Page<EsPatients> esPatientsPage = esPatientsService.search(keyword,field, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esPatientsPage));
    }

}
