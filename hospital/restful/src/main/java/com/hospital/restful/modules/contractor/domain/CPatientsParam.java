package com.hospital.restful.modules.contractor.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * 病人信息表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CPatientsParam {
  @NotEmpty
  @ApiModelProperty(value = "病人姓名",required = true)
  private String Name;
  @NotEmpty
  @ApiModelProperty(value = "性别",required = true)
  private String Gender;
  @NotNull
  @ApiModelProperty(value = "出生日期",required = true)
  private Date DateOfBirth;
  @ApiModelProperty(value = "联系电话",required = false)
  private String ContactNumber;
  @ApiModelProperty(value = "地址",required = false)
  private String Address;
  @ApiModelProperty(value = "紧急联系人",required = false)
  private String EmergencyContact;
  @ApiModelProperty(value = "身份证号",required = false)
  private String Id_card_number;
  @NotEmpty
  @ApiModelProperty(value = "证件类型",required = true)
  private String Id_card_type;
  @ApiModelProperty(value = "证件有效期",required = false)
  private Date Id_card_expiry;
}
