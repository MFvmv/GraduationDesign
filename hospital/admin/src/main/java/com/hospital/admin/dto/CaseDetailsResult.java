package com.hospital.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CaseDetailsResult {
    @ApiModelProperty(value = "病历日期")
    private Date RecordDate;

    @ApiModelProperty(value = "诊断记录")
    private String Diagnosis;

    @ApiModelProperty(value = "治疗计划")
    private String TreatmentPlan;

    @ApiModelProperty(value = "检查报告")
    private String TestReports;

    @ApiModelProperty(value = "影像数据")
    private String image_data;
}
