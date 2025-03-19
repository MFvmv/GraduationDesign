package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Hospitalbeds implements Serializable {
    @ApiModelProperty(value = "病床唯一标识")
    private Integer BedID;

    @ApiModelProperty(value = "病房号")
    private String RoomNumber;

    @ApiModelProperty(value = "床号")
    private Integer BedNumber;

    @ApiModelProperty(value = "病床状态")
    private String BedStatus;

    @ApiModelProperty(value = "当前占用该床的病人ID")
    private Integer PatientID;

    @ApiModelProperty(value = "最后更新时间")
    private Date LastUpdated;

    private static final long serialVersionUID = 1L;

    public Integer getBedID() {
        return BedID;
    }

    public void setBedID(Integer BedID) {
        this.BedID = BedID;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public Integer getBedNumber() {
        return BedNumber;
    }

    public void setBedNumber(Integer BedNumber) {
        this.BedNumber = BedNumber;
    }

    public String getBedStatus() {
        return BedStatus;
    }

    public void setBedStatus(String BedStatus) {
        this.BedStatus = BedStatus;
    }

    public Integer getPatientID() {
        return PatientID;
    }

    public void setPatientID(Integer PatientID) {
        this.PatientID = PatientID;
    }

    public Date getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(Date LastUpdated) {
        this.LastUpdated = LastUpdated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", BedID=").append(BedID);
        sb.append(", RoomNumber=").append(RoomNumber);
        sb.append(", BedNumber=").append(BedNumber);
        sb.append(", BedStatus=").append(BedStatus);
        sb.append(", PatientID=").append(PatientID);
        sb.append(", LastUpdated=").append(LastUpdated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        BedID("BedID", "BedID", "INTEGER", false),
        RoomNumber("RoomNumber", "RoomNumber", "VARCHAR", false),
        BedNumber("BedNumber", "BedNumber", "INTEGER", false),
        BedStatus("BedStatus", "BedStatus", "CHAR", false),
        PatientID("PatientID", "PatientID", "INTEGER", false),
        LastUpdated("LastUpdated", "LastUpdated", "TIMESTAMP", false);

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