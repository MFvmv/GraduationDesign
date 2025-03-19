package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Patientsummary implements Serializable {
    @ApiModelProperty(value = "病人唯一标识")
    private Integer 病人唯一标识;

    @ApiModelProperty(value = "病人姓名")
    private String 病人姓名;

    private Long 总挂号次数;

    private Long 总住院次数;

    private static final long serialVersionUID = 1L;

    public Integer get病人唯一标识() {
        return 病人唯一标识;
    }

    public void set病人唯一标识(Integer 病人唯一标识) {
        this.病人唯一标识 = 病人唯一标识;
    }

    public String get病人姓名() {
        return 病人姓名;
    }

    public void set病人姓名(String 病人姓名) {
        this.病人姓名 = 病人姓名;
    }

    public Long get总挂号次数() {
        return 总挂号次数;
    }

    public void set总挂号次数(Long 总挂号次数) {
        this.总挂号次数 = 总挂号次数;
    }

    public Long get总住院次数() {
        return 总住院次数;
    }

    public void set总住院次数(Long 总住院次数) {
        this.总住院次数 = 总住院次数;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", 病人唯一标识=").append(病人唯一标识);
        sb.append(", 病人姓名=").append(病人姓名);
        sb.append(", 总挂号次数=").append(总挂号次数);
        sb.append(", 总住院次数=").append(总住院次数);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        病人唯一标识("病人唯一标识", "病人唯一标识", "INTEGER", false),
        病人姓名("病人姓名", "病人姓名", "VARCHAR", false),
        总挂号次数("总挂号次数", "总挂号次数", "BIGINT", false),
        总住院次数("总住院次数", "总住院次数", "BIGINT", false);

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