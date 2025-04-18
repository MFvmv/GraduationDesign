package com.hospital.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddModel3DJSONParam {
    @ApiModelProperty(value = "关联病床ID",required = false)
    private Integer bed_id;

    @ApiModelProperty(value = "楼层号",required = true)
    private Integer floor_number;

    @ApiModelProperty(value = "存储3D模型的JSON格式数据",required = true)
    private String model_data;
}
