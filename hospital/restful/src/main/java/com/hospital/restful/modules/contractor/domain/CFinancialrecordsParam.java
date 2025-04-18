package com.hospital.restful.modules.contractor.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
/**
 * 财务管理表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CFinancialrecordsParam {
  @ApiModelProperty(value = "病人唯一标识（外键）",required = false)
  private Integer PatientID;
  @NotNull
  @ApiModelProperty(value = "金额",required = true)
  private BigDecimal Amount;
  @NotEmpty
  @ApiModelProperty(value = "支付方式",required = true)
  private String PaymentMethod;
  @ApiModelProperty(value = "描述",required = false)
  private String Description;
  @NotEmpty
  @ApiModelProperty(value = "支付状态",required = true)
  private String PaymentStatus;
  @ApiModelProperty(value = "订单号",required = false)
  private String OrderNumber;
}
