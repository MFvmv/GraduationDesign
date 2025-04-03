package com.hospital.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DoctorsInfoResult {
    @ApiModelProperty(value = "医生唯一标识")
    private Integer DoctorID;

    @ApiModelProperty(value = "所属科室")
    private String Department;

    @ApiModelProperty(value = "医生姓名")
    private String Name;
}
