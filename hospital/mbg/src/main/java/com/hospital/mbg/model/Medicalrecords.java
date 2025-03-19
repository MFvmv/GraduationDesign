package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Medicalrecords implements Serializable {
    @ApiModelProperty(value = "病历唯一标识")
    private Integer RecordID;

    @ApiModelProperty(value = "病人唯一标识（外键）")
    private Integer PatientID;

    @ApiModelProperty(value = "病历日期")
    private Date RecordDate;

    @ApiModelProperty(value = "诊断记录")
    private String Diagnosis;

    @ApiModelProperty(value = "治疗计划")
    private String TreatmentPlan;

    @ApiModelProperty(value = "检查报告")
    private String TestReports;

    @ApiModelProperty(value = "影像数据")
    private String image_data;

    private static final long serialVersionUID = 1L;

    public Integer getRecordID() {
        return RecordID;
    }

    public void setRecordID(Integer RecordID) {
        this.RecordID = RecordID;
    }

    public Integer getPatientID() {
        return PatientID;
    }

    public void setPatientID(Integer PatientID) {
        this.PatientID = PatientID;
    }

    public Date getRecordDate() {
        return RecordDate;
    }

    public void setRecordDate(Date RecordDate) {
        this.RecordDate = RecordDate;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }

    public String getTreatmentPlan() {
        return TreatmentPlan;
    }

    public void setTreatmentPlan(String TreatmentPlan) {
        this.TreatmentPlan = TreatmentPlan;
    }

    public String getTestReports() {
        return TestReports;
    }

    public void setTestReports(String TestReports) {
        this.TestReports = TestReports;
    }

    public String getImage_data() {
        return image_data;
    }

    public void setImage_data(String image_data) {
        this.image_data = image_data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", RecordID=").append(RecordID);
        sb.append(", PatientID=").append(PatientID);
        sb.append(", RecordDate=").append(RecordDate);
        sb.append(", Diagnosis=").append(Diagnosis);
        sb.append(", TreatmentPlan=").append(TreatmentPlan);
        sb.append(", TestReports=").append(TestReports);
        sb.append(", image_data=").append(image_data);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        RecordID("RecordID", "RecordID", "INTEGER", false),
        PatientID("PatientID", "PatientID", "INTEGER", false),
        RecordDate("RecordDate", "RecordDate", "TIMESTAMP", false),
        Diagnosis("Diagnosis", "Diagnosis", "LONGVARCHAR", false),
        TreatmentPlan("TreatmentPlan", "TreatmentPlan", "LONGVARCHAR", false),
        TestReports("TestReports", "TestReports", "LONGVARCHAR", false),
        image_data("image_data", "image_data", "LONGVARCHAR", false);

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