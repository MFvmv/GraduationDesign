package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Appointments implements Serializable {
    @ApiModelProperty(value = "挂号唯一标识")
    private Integer AppointmentID;

    @ApiModelProperty(value = "病人唯一标识（外键）")
    private Integer PatientID;

    @ApiModelProperty(value = "预约日期")
    private Date AppointmentDate;

    @ApiModelProperty(value = "就诊时段（上午 / 下午）")
    private String AppointmentSession;

    @ApiModelProperty(value = "预约状态")
    private String Status;

    @ApiModelProperty(value = "创建时间")
    private Date CreatedAt;

    @ApiModelProperty(value = "医生唯一标识（外键）")
    private Integer DoctorID;

    private static final long serialVersionUID = 1L;

    public Integer getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(Integer AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    public Integer getPatientID() {
        return PatientID;
    }

    public void setPatientID(Integer PatientID) {
        this.PatientID = PatientID;
    }

    public Date getAppointmentDate() {
        return AppointmentDate;
    }

    public void setAppointmentDate(Date AppointmentDate) {
        this.AppointmentDate = AppointmentDate;
    }

    public String getAppointmentSession() {
        return AppointmentSession;
    }

    public void setAppointmentSession(String AppointmentSession) {
        this.AppointmentSession = AppointmentSession;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public Integer getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(Integer DoctorID) {
        this.DoctorID = DoctorID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", AppointmentID=").append(AppointmentID);
        sb.append(", PatientID=").append(PatientID);
        sb.append(", AppointmentDate=").append(AppointmentDate);
        sb.append(", AppointmentSession=").append(AppointmentSession);
        sb.append(", Status=").append(Status);
        sb.append(", CreatedAt=").append(CreatedAt);
        sb.append(", DoctorID=").append(DoctorID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        AppointmentID("AppointmentID", "AppointmentID", "INTEGER", false),
        PatientID("PatientID", "PatientID", "INTEGER", false),
        AppointmentDate("AppointmentDate", "AppointmentDate", "DATE", false),
        AppointmentSession("AppointmentSession", "AppointmentSession", "CHAR", false),
        Status("Status", "Status", "CHAR", false),
        CreatedAt("CreatedAt", "CreatedAt", "TIMESTAMP", false),
        DoctorID("DoctorID", "DoctorID", "INTEGER", false);

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