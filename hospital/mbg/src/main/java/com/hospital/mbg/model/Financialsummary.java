package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Financialsummary implements Serializable {
    @ApiModelProperty(value = "病人唯一标识（外键）")
    private Integer 病人唯一标识;

    private BigDecimal 支付总额;

    private Long 总交易次数;

    private static final long serialVersionUID = 1L;

    public Integer get病人唯一标识() {
        return 病人唯一标识;
    }

    public void set病人唯一标识(Integer 病人唯一标识) {
        this.病人唯一标识 = 病人唯一标识;
    }

    public BigDecimal get支付总额() {
        return 支付总额;
    }

    public void set支付总额(BigDecimal 支付总额) {
        this.支付总额 = 支付总额;
    }

    public Long get总交易次数() {
        return 总交易次数;
    }

    public void set总交易次数(Long 总交易次数) {
        this.总交易次数 = 总交易次数;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", 病人唯一标识=").append(病人唯一标识);
        sb.append(", 支付总额=").append(支付总额);
        sb.append(", 总交易次数=").append(总交易次数);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        病人唯一标识("病人唯一标识", "病人唯一标识", "INTEGER", false),
        支付总额("支付总额", "支付总额", "DECIMAL", false),
        总交易次数("总交易次数", "总交易次数", "BIGINT", false);

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