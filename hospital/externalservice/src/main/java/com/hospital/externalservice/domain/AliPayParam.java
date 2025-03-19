package com.hospital.externalservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @auther macrozheng
 * @description 支付宝支付请求参数
 * @date 2023/9/8
 * @github https://github.com/macrozheng
 */
@Data
public class AliPayParam {
    /**
     * 商户订单号，商家自定义，保持唯一性
     */
    @NotEmpty
    @ApiModelProperty(value = "商户订单号，商家自定义，保持唯一性",required = true)
    private String outTradeNo;
    /**
     * 商品的标题/交易标题/订单标题/订单关键字等
     */
    @NotEmpty
    @ApiModelProperty(value = "商品的标题/交易标题/订单标题/订单关键字等",required = true)
    private String subject;
    /**
     * 订单总金额，单位为元，精确到小数点后两位
     */
    @NotNull
    @ApiModelProperty(value = "订单总金额，单位为元，精确到小数点后两位",required = true)
    private BigDecimal totalAmount;
}
