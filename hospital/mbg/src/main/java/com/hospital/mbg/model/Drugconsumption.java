package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Drugconsumption implements Serializable {
    @ApiModelProperty(value = "药品消耗唯一标识")
    private Integer ConsumptionID;

    @ApiModelProperty(value = "药品唯一标识（外键）")
    private Integer DrugID;

    @ApiModelProperty(value = "病人唯一标识（外键）")
    private Integer PatientID;

    @ApiModelProperty(value = "使用数量")
    private Integer QuantityUsed;

    @ApiModelProperty(value = "更新时间")
    private Date LastUpdated;

    @ApiModelProperty(value = "用时总量")
    private Integer Count;

    private static final long serialVersionUID = 1L;

    public Integer getConsumptionID() {
        return ConsumptionID;
    }

    public void setConsumptionID(Integer ConsumptionID) {
        this.ConsumptionID = ConsumptionID;
    }

    public Integer getDrugID() {
        return DrugID;
    }

    public void setDrugID(Integer DrugID) {
        this.DrugID = DrugID;
    }

    public Integer getPatientID() {
        return PatientID;
    }

    public void setPatientID(Integer PatientID) {
        this.PatientID = PatientID;
    }

    public Integer getQuantityUsed() {
        return QuantityUsed;
    }

    public void setQuantityUsed(Integer QuantityUsed) {
        this.QuantityUsed = QuantityUsed;
    }

    public Date getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(Date LastUpdated) {
        this.LastUpdated = LastUpdated;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer Count) {
        this.Count = Count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ConsumptionID=").append(ConsumptionID);
        sb.append(", DrugID=").append(DrugID);
        sb.append(", PatientID=").append(PatientID);
        sb.append(", QuantityUsed=").append(QuantityUsed);
        sb.append(", LastUpdated=").append(LastUpdated);
        sb.append(", Count=").append(Count);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        ConsumptionID("ConsumptionID", "ConsumptionID", "INTEGER", false),
        DrugID("DrugID", "DrugID", "INTEGER", false),
        PatientID("PatientID", "PatientID", "INTEGER", false),
        QuantityUsed("QuantityUsed", "QuantityUsed", "INTEGER", false),
        LastUpdated("LastUpdated", "LastUpdated", "TIMESTAMP", false),
        Count("Count", "Count", "INTEGER", false);

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