package com.hospital.restful.modules.contractor.dto;

import com.hospital.restful.modules.contractor.domain.CInpatientsParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 住院管理表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CUInpatientsMixParam {
  @NotNull
  @ApiModelProperty(value = "药品记录参数对象，用于创建新的药品记录表行", required = true)
  private CInpatientsParam inpatientsParam;

  @ApiModelProperty(value = "财务表唯一标识，用于关联财务表，为null默认不关联", required = false)
  private Integer TransactionID;
}
