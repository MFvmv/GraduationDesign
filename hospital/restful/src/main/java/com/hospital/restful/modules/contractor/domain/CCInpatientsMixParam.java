package com.hospital.restful.modules.contractor.domain;

import com.hospital.restful.modules.contractor.annotations.ValidFinancialRecords;
import com.hospital.restful.modules.contractor.dto.CInpatientsParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 住院管理表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
@ValidFinancialRecords  // 添加自定义校验注解
public class CCInpatientsMixParam {
  @NotNull
  @ApiModelProperty(value = "住院管理参数对象",required = true)
  private CInpatientsParam inpatientsParam;

  @ApiModelProperty(value = "财务参数对象，用于创建新的财务表行,为null默认不创建", required = false)
  private CFinancialrecordsMinParam financialrecordsParam;

  @ApiModelProperty(value = "财务表唯一标识，用于关联财务表，为null默认不关联", required = false)
  private Integer TransactionID;

}
