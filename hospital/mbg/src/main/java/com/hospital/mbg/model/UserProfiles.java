package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class UserProfiles implements Serializable {
    @ApiModelProperty(value = "唯一标识，自动递增主键")
    private Long id;

    @ApiModelProperty(value = "外键，关联到 users 表的主键，确保每个用户只有一条记录")
    private Integer user_id;

    @ApiModelProperty(value = "用户的名")
    private String first_name;

    @ApiModelProperty(value = "用户的姓")
    private String last_name;

    @ApiModelProperty(value = "性别（Male：男性，Female：女性）")
    private String gender;

    @ApiModelProperty(value = "用户的出生日期")
    private Date date_of_birth;

    @ApiModelProperty(value = "头像 URL，用户上传的头像图片链接")
    private String profile_picture;

    @ApiModelProperty(value = "用户的详细地址")
    private String address;

    @ApiModelProperty(value = "用户所在的城市")
    private String city;

    @ApiModelProperty(value = "用户所在的省或州")
    private String state;

    @ApiModelProperty(value = "用户的邮政编码")
    private String postal_code;

    @ApiModelProperty(value = "用户所在的国家")
    private String country;

    @ApiModelProperty(value = "记录创建的时间戳")
    private Date created_at;

    @ApiModelProperty(value = "记录最后更新时间")
    private Date updated_at;

    @ApiModelProperty(value = "个人简介或自我描述")
    private String bio;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user_id=").append(user_id);
        sb.append(", first_name=").append(first_name);
        sb.append(", last_name=").append(last_name);
        sb.append(", gender=").append(gender);
        sb.append(", date_of_birth=").append(date_of_birth);
        sb.append(", profile_picture=").append(profile_picture);
        sb.append(", address=").append(address);
        sb.append(", city=").append(city);
        sb.append(", state=").append(state);
        sb.append(", postal_code=").append(postal_code);
        sb.append(", country=").append(country);
        sb.append(", created_at=").append(created_at);
        sb.append(", updated_at=").append(updated_at);
        sb.append(", bio=").append(bio);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        id("id", "id", "BIGINT", false),
        user_id("user_id", "user_id", "INTEGER", false),
        first_name("first_name", "first_name", "VARCHAR", false),
        last_name("last_name", "last_name", "VARCHAR", false),
        gender("gender", "gender", "CHAR", false),
        date_of_birth("date_of_birth", "date_of_birth", "DATE", false),
        profile_picture("profile_picture", "profile_picture", "VARCHAR", false),
        address("address", "address", "VARCHAR", false),
        city("city", "city", "VARCHAR", false),
        state("state", "state", "VARCHAR", false),
        postal_code("postal_code", "postal_code", "VARCHAR", false),
        country("country", "country", "VARCHAR", false),
        created_at("created_at", "created_at", "TIMESTAMP", false),
        updated_at("updated_at", "updated_at", "TIMESTAMP", false),
        bio("bio", "bio", "LONGVARCHAR", false);

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