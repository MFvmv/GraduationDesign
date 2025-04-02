package com.hospital.restful.modules.contractor.dto;

import com.hospital.restful.modules.contractor.domain.CDrugconsumptionParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 药品消耗记录表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CUDrugconsumptionMixParam {
  @NotNull
  @ApiModelProperty(value = "药品记录参数对象，用于创建新的药品记录表行", required = true)
  private CDrugconsumptionParam drugconsumptionParam;

  @ApiModelProperty(value = "财务表唯一标识，用于更新关联财务表，为null默认不更新关联", required = false)
  private Integer TransactionID;
}
