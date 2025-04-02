package com.hospital.restful.modules.contractor.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * 挂号与预约表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CAppointmentsParam {
  @NotNull
  @ApiModelProperty(value = "病人唯一标识（外键）",required = true)
  private Integer PatientID;
  @NotNull
  @ApiModelProperty(value = "预约日期",required = true)
  private Date AppointmentDate;
  @NotEmpty
  @ApiModelProperty(value = "预约时间",required = true)
  private Date AppointmentTime;
  @NotEmpty
  @ApiModelProperty(value = "科室",required = true)
  private String Department;
  @ApiModelProperty(value = "医生姓名",required = false)
  private String DoctorName;
  @ApiModelProperty(value = "预约状态",required = false)
  private String Status;
}
