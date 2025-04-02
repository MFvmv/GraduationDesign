package com.hospital.restful.modules.contractor.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * 病床管理表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CHospitalbedsParam {
  @NotEmpty
  @ApiModelProperty(value = "病房号",required = true)
  private String RoomNumber;
  @NotNull
  @ApiModelProperty(value = "床号",required = true)
  private Integer BedNumber;
  @NotEmpty
  @ApiModelProperty(value = "病床状态",required = true)
  private String BedStatus;
  @ApiModelProperty(value = "当前占用该床的病人ID",required = false)
  private Integer PatientID;
}
