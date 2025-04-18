package com.hospital.admin.controller;

import com.hospital.admin.dto.AddModel3DJSONParam;
import com.hospital.admin.service.ModelService;
import com.hospital.common.api.CommonResult;
import com.hospital.mbg.model.SpaceModel3dJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "ModelController")
@Tag(name = "ModelController", description = "床位模型管理")
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @ApiOperation(value = "按楼层数获得模型")
    @RequestMapping(value = "/getByFloor", method = RequestMethod.GET)
    public CommonResult getByFloor(int floor_number) {
        List<SpaceModel3dJson> list = modelService.getByFloor(floor_number);
        return CommonResult.success(list,"查询成功");
    }

    @ApiOperation(value = "绑定床位信息")
    @RequestMapping(value = "/bindBed", method = RequestMethod.GET)
    public CommonResult bindBed(int ModleID,String RoomNumber,int BedNumber) {
        if(modelService.bindBed(ModleID,RoomNumber,BedNumber))
            return CommonResult.success(null,"绑定床位信息成功");
        return CommonResult.failed("绑定床位信息失败");
    }
    @ApiOperation(value = "删除模型数据")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public CommonResult Delete(int ModleID) {
        if(modelService.delete(ModleID))
            return CommonResult.success(null,"删除成功");
        return CommonResult.failed("删除失败");
    }

    @ApiOperation(value = "添加模型数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody AddModel3DJSONParam param) {
        int r = modelService.add(param);
        if(r != -1)
            return CommonResult.success(r,"添加成功");
        return CommonResult.failed("添加失败");
    }
}