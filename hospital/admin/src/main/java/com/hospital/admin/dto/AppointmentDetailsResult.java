package com.hospital.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

@Data
public class AppointmentDetailsResult {
    @ApiModelProperty(value = "预约日期")
    private Date appointmentDate;

    @ApiModelProperty(value = "就诊时段（上午/下午）")
    private String appointmentSession;

    @ApiModelProperty(value = "医生姓名")
    private String doctorsName;

    @ApiModelProperty(value = "医生性别")
    private String gender;
    // 所属科室
    @ApiModelProperty(value = "所属科室")
    private String department;

    @ApiModelProperty(value = "同一医生、同一预约日期和时段内的序号")
    private String status;

    @ApiModelProperty(value = "同一医生、同一预约日期和时段内的序号")
    private Integer number;
}
