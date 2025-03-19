package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Alipaytransactions implements Serializable {
    @ApiModelProperty(value = "支付宝交易记录唯一标识")
    private Integer AlipayTransactionID;

    @ApiModelProperty(value = "订单号")
    private String OrderNumber;

    @ApiModelProperty(value = "总金额")
    private BigDecimal TotalAmount;

    @ApiModelProperty(value = "交易状态")
    private String TradeStatus;

    private static final long serialVersionUID = 1L;

    public Integer getAlipayTransactionID() {
        return AlipayTransactionID;
    }

    public void setAlipayTransactionID(Integer AlipayTransactionID) {
        this.AlipayTransactionID = AlipayTransactionID;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }

    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(BigDecimal TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public String getTradeStatus() {
        return TradeStatus;
    }

    public void setTradeStatus(String TradeStatus) {
        this.TradeStatus = TradeStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", AlipayTransactionID=").append(AlipayTransactionID);
        sb.append(", OrderNumber=").append(OrderNumber);
        sb.append(", TotalAmount=").append(TotalAmount);
        sb.append(", TradeStatus=").append(TradeStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        AlipayTransactionID("AlipayTransactionID", "AlipayTransactionID", "INTEGER", false),
        OrderNumber("OrderNumber", "OrderNumber", "VARCHAR", false),
        TotalAmount("TotalAmount", "TotalAmount", "DECIMAL", false),
        TradeStatus("TradeStatus", "TradeStatus", "CHAR", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}