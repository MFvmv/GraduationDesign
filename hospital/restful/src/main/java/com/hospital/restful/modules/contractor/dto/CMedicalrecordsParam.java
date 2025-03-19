package com.hospital.restful.modules.contractor.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
/**
 * 病历管理表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CMedicalrecordsParam {
  @NotNull
  @ApiModelProperty(value = "病人唯一标识（外键）",required = true)
  private Integer PatientID;
  @NotEmpty
  @ApiModelProperty(value = "诊断记录",required = true)
  private String Diagnosis;
  @ApiModelProperty(value = "治疗计划",required = false)
  private String TreatmentPlan;
  @ApiModelProperty(value = "检查报告",required = false)
  private String TestReports;
  @ApiModelProperty(value = "影像数据")
  private String image_data;
}
