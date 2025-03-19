package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Inpatients implements Serializable {
    @ApiModelProperty(value = "住院唯一标识")
    private Integer InpatientID;

    @ApiModelProperty(value = "病人唯一标识（外键）")
    private Integer PatientID;

    @ApiModelProperty(value = "入院日期")
    private Date AdmissionDate;

    @ApiModelProperty(value = "出院日期")
    private Date DischargeDate;

    @ApiModelProperty(value = "病房号")
    private String RoomNumber;

    @ApiModelProperty(value = "床号")
    private Integer BedNumber;

    @ApiModelProperty(value = "当前状态")
    private String CurrentStatus;

    private static final long serialVersionUID = 1L;

    public Integer getInpatientID() {
        return InpatientID;
    }

    public void setInpatientID(Integer InpatientID) {
        this.InpatientID = InpatientID;
    }

    public Integer getPatientID() {
        return PatientID;
    }

    public void setPatientID(Integer PatientID) {
        this.PatientID = PatientID;
    }

    public Date getAdmissionDate() {
        return AdmissionDate;
    }

    public void setAdmissionDate(Date AdmissionDate) {
        this.AdmissionDate = AdmissionDate;
    }

    public Date getDischargeDate() {
        return DischargeDate;
    }

    public void setDischargeDate(Date DischargeDate) {
        this.DischargeDate = DischargeDate;
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

    public String getCurrentStatus() {
        return CurrentStatus;
    }

    public void setCurrentStatus(String CurrentStatus) {
        this.CurrentStatus = CurrentStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", InpatientID=").append(InpatientID);
        sb.append(", PatientID=").append(PatientID);
        sb.append(", AdmissionDate=").append(AdmissionDate);
        sb.append(", DischargeDate=").append(DischargeDate);
        sb.append(", RoomNumber=").append(RoomNumber);
        sb.append(", BedNumber=").append(BedNumber);
        sb.append(", CurrentStatus=").append(CurrentStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        InpatientID("InpatientID", "InpatientID", "INTEGER", false),
        PatientID("PatientID", "PatientID", "INTEGER", false),
        AdmissionDate("AdmissionDate", "AdmissionDate", "DATE", false),
        DischargeDate("DischargeDate", "DischargeDate", "DATE", false),
        RoomNumber("RoomNumber", "RoomNumber", "VARCHAR", false),
        BedNumber("BedNumber", "BedNumber", "INTEGER", false),
        CurrentStatus("CurrentStatus", "CurrentStatus", "CHAR", false);

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