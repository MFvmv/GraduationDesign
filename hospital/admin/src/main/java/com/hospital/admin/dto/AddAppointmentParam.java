package com.hospital.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AddAppointmentParam {
    @ApiModelProperty(value = "医生唯一标识")
    private Integer DoctorID;

    @ApiModelProperty(value = "预约日期")
    private Date AppointmentDate;

    @ApiModelProperty(value = "就诊时段（上午 / 下午）")
    private String AppointmentSession;
}
