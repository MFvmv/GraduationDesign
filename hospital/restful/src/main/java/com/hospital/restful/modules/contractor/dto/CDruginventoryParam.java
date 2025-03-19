package com.hospital.restful.modules.contractor.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
/**
 * 药品库存管理表参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode
public class CDruginventoryParam {
  @NotEmpty
  @ApiModelProperty(value = "药品名称",required = true)
  private String DrugName;
  @ApiModelProperty(value = "药品类别",required = false)
  private String Category;
  @NotNull
  @ApiModelProperty(value = "库存数量",required = true)
  private Integer Quantity;
  @NotNull
  @ApiModelProperty(value = "单价",required = true)
  private BigDecimal UnitPrice;
  @ApiModelProperty(value = "供应商名称",required = false)
  private String SupplierName;
  @ApiModelProperty(value = "药品制作日期",required = false)
  private Date ManufactureDate;
  @ApiModelProperty(value = "药品有效日期",required = false)
  private Date ExpiryDate;
}
