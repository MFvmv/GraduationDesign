package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Financialrecords implements Serializable {
    @ApiModelProperty(value = "财务记录唯一标识")
    private Integer TransactionID;

    @ApiModelProperty(value = "病人唯一标识（外键）")
    private Integer PatientID;

    @ApiModelProperty(value = "金额")
    private BigDecimal Amount;

    @ApiModelProperty(value = "交易日期")
    private Date TransactionDate;

    @ApiModelProperty(value = "支付方式")
    private String PaymentMethod;

    @ApiModelProperty(value = "支付状态")
    private String PaymentStatus;

    @ApiModelProperty(value = "订单号")
    private String OrderNumber;

    @ApiModelProperty(value = "描述")
    private String Description;

    private static final long serialVersionUID = 1L;

    public Integer getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(Integer TransactionID) {
        this.TransactionID = TransactionID;
    }

    public Integer getPatientID() {
        return PatientID;
    }

    public void setPatientID(Integer PatientID) {
        this.PatientID = PatientID;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal Amount) {
        this.Amount = Amount;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date TransactionDate) {
        this.TransactionDate = TransactionDate;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", TransactionID=").append(TransactionID);
        sb.append(", PatientID=").append(PatientID);
        sb.append(", Amount=").append(Amount);
        sb.append(", TransactionDate=").append(TransactionDate);
        sb.append(", PaymentMethod=").append(PaymentMethod);
        sb.append(", PaymentStatus=").append(PaymentStatus);
        sb.append(", OrderNumber=").append(OrderNumber);
        sb.append(", Description=").append(Description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        TransactionID("TransactionID", "TransactionID", "INTEGER", false),
        PatientID("PatientID", "PatientID", "INTEGER", false),
        Amount("Amount", "Amount", "DECIMAL", false),
        TransactionDate("TransactionDate", "TransactionDate", "DATE", false),
        PaymentMethod("PaymentMethod", "PaymentMethod", "CHAR", false),
        PaymentStatus("PaymentStatus", "PaymentStatus", "CHAR", false),
        OrderNumber("OrderNumber", "OrderNumber", "VARCHAR", false),
        Description("Description", "Description", "LONGVARCHAR", false);

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