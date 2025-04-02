package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Doctors implements Serializable {
    @ApiModelProperty(value = "医生唯一标识")
    private Integer DoctorID;

    @ApiModelProperty(value = "医生姓名")
    private String Name;

    @ApiModelProperty(value = "性别")
    private String Gender;

    @ApiModelProperty(value = "联系方式")
    private String Phone;

    @ApiModelProperty(value = "电子邮件")
    private String Email;

    @ApiModelProperty(value = "所属科室")
    private String Department;

    @ApiModelProperty(value = "专业方向")
    private String Specialization;

    @ApiModelProperty(value = "创建时间")
    private Date CreatedAt;

    private static final long serialVersionUID = 1L;

    public Integer getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(Integer DoctorID) {
        this.DoctorID = DoctorID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", DoctorID=").append(DoctorID);
        sb.append(", Name=").append(Name);
        sb.append(", Gender=").append(Gender);
        sb.append(", Phone=").append(Phone);
        sb.append(", Email=").append(Email);
        sb.append(", Department=").append(Department);
        sb.append(", Specialization=").append(Specialization);
        sb.append(", CreatedAt=").append(CreatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        DoctorID("DoctorID", "DoctorID", "INTEGER", false),
        Name("Name", "Name", "VARCHAR", false),
        Gender("Gender", "Gender", "CHAR", false),
        Phone("Phone", "Phone", "VARCHAR", false),
        Email("Email", "Email", "VARCHAR", false),
        Department("Department", "Department", "VARCHAR", false),
        Specialization("Specialization", "Specialization", "VARCHAR", false),
        CreatedAt("CreatedAt", "CreatedAt", "TIMESTAMP", false);

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