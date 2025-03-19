package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class FinancialrecordsDrugconsumptionRelation implements Serializable {
    @ApiModelProperty(value = "药品消耗唯一标识（外键）")
    private Integer ConsumptionID;

    @ApiModelProperty(value = "财务记录唯一标识（外键）")
    private Integer TransactionID;

    private static final long serialVersionUID = 1L;

    public Integer getConsumptionID() {
        return ConsumptionID;
    }

    public void setConsumptionID(Integer ConsumptionID) {
        this.ConsumptionID = ConsumptionID;
    }

    public Integer getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(Integer TransactionID) {
        this.TransactionID = TransactionID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ConsumptionID=").append(ConsumptionID);
        sb.append(", TransactionID=").append(TransactionID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        ConsumptionID("ConsumptionID", "ConsumptionID", "INTEGER", false),
        TransactionID("TransactionID", "TransactionID", "INTEGER", false);

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