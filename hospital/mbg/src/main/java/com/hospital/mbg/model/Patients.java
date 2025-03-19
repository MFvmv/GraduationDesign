package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Patients implements Serializable {
    @ApiModelProperty(value = "病人唯一标识")
    private Integer PatientID;

    @ApiModelProperty(value = "病人姓名")
    private String Name;

    @ApiModelProperty(value = "性别")
    private String Gender;

    @ApiModelProperty(value = "出生日期")
    private Date DateOfBirth;

    @ApiModelProperty(value = "联系电话")
    private String ContactNumber;

    @ApiModelProperty(value = "紧急联系人")
    private String EmergencyContact;

    @ApiModelProperty(value = "创建时间")
    private Date CreatedAt;

    @ApiModelProperty(value = "身份证号")
    private String id_card_number;

    @ApiModelProperty(value = "证件类型")
    private String id_card_type;

    @ApiModelProperty(value = "证件有效期")
    private Date id_card_expiry;

    @ApiModelProperty(value = "地址")
    private String Address;

    private static final long serialVersionUID = 1L;

    public Integer getPatientID() {
        return PatientID;
    }

    public void setPatientID(Integer PatientID) {
        this.PatientID = PatientID;
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

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getEmergencyContact() {
        return EmergencyContact;
    }

    public void setEmergencyContact(String EmergencyContact) {
        this.EmergencyContact = EmergencyContact;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getId_card_type() {
        return id_card_type;
    }

    public void setId_card_type(String id_card_type) {
        this.id_card_type = id_card_type;
    }

    public Date getId_card_expiry() {
        return id_card_expiry;
    }

    public void setId_card_expiry(Date id_card_expiry) {
        this.id_card_expiry = id_card_expiry;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", PatientID=").append(PatientID);
        sb.append(", Name=").append(Name);
        sb.append(", Gender=").append(Gender);
        sb.append(", DateOfBirth=").append(DateOfBirth);
        sb.append(", ContactNumber=").append(ContactNumber);
        sb.append(", EmergencyContact=").append(EmergencyContact);
        sb.append(", CreatedAt=").append(CreatedAt);
        sb.append(", id_card_number=").append(id_card_number);
        sb.append(", id_card_type=").append(id_card_type);
        sb.append(", id_card_expiry=").append(id_card_expiry);
        sb.append(", Address=").append(Address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        PatientID("PatientID", "PatientID", "INTEGER", false),
        Name("Name", "Name", "VARCHAR", false),
        Gender("Gender", "Gender", "CHAR", false),
        DateOfBirth("DateOfBirth", "DateOfBirth", "DATE", false),
        ContactNumber("ContactNumber", "ContactNumber", "VARCHAR", false),
        EmergencyContact("EmergencyContact", "EmergencyContact", "VARCHAR", false),
        CreatedAt("CreatedAt", "CreatedAt", "TIMESTAMP", false),
        id_card_number("id_card_number", "id_card_number", "VARCHAR", false),
        id_card_type("id_card_type", "id_card_type", "CHAR", false),
        id_card_expiry("id_card_expiry", "id_card_expiry", "DATE", false),
        Address("Address", "Address", "LONGVARCHAR", false);

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