package com.hospital.restful.modules.contractor.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
/**
 * 药品消耗记录表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CDrugconsumptionParam {
  @NotNull
  @ApiModelProperty(value = "药品唯一标识（外键）",required = true)
  private Integer DrugID;
  @ApiModelProperty(value = "病人唯一标识（外键）",required = false)
  private Integer PatientID;
  @NotNull
  @ApiModelProperty(value = "使用数量",required = true)
  private Integer QuantityUsed;
  @ApiModelProperty(value = "用时总量",required = false)
  private Integer Count;
}
