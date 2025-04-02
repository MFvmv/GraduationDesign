package com.hospital.restful.modules.contractor.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * 住院管理表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CInpatientsParam {
  @NotNull
  @ApiModelProperty(value = "病人唯一标识（外键）",required = true)
  private Integer PatientID;
  @NotNull
  @ApiModelProperty(value = "入院日期",required = true)
  private Date AdmissionDate;
  @ApiModelProperty(value = "出院日期",required = false)
  private Date DischargeDate;
  @NotEmpty
  @ApiModelProperty(value = "病房号",required = true)
  private String RoomNumber;
  @NotNull
  @ApiModelProperty(value = "床号",required = true)
  private Integer BedNumber;
  @NotEmpty
  @ApiModelProperty(value = "当前状态",required = true)
  private String CurrentStatus;
}
