package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class SpaceModel3dJson implements Serializable {
    @ApiModelProperty(value = "3D模型记录ID")
    private Integer id;

    @ApiModelProperty(value = "关联病床ID")
    private Integer bed_id;

    @ApiModelProperty(value = "楼层号")
    private Integer floor_number;

    @ApiModelProperty(value = "记录创建时间")
    private Date created_at;

    @ApiModelProperty(value = "记录更新时间")
    private Date updated_at;

    @ApiModelProperty(value = "存储3D模型的JSON格式数据")
    private String model_data;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBed_id() {
        return bed_id;
    }

    public void setBed_id(Integer bed_id) {
        this.bed_id = bed_id;
    }

    public Integer getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(Integer floor_number) {
        this.floor_number = floor_number;
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

    public String getModel_data() {
        return model_data;
    }

    public void setModel_data(String model_data) {
        this.model_data = model_data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bed_id=").append(bed_id);
        sb.append(", floor_number=").append(floor_number);
        sb.append(", created_at=").append(created_at);
        sb.append(", updated_at=").append(updated_at);
        sb.append(", model_data=").append(model_data);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        id("id", "id", "INTEGER", false),
        bed_id("bed_id", "bed_id", "INTEGER", false),
        floor_number("floor_number", "floor_number", "INTEGER", false),
        created_at("created_at", "created_at", "TIMESTAMP", false),
        updated_at("updated_at", "updated_at", "TIMESTAMP", false),
        model_data("model_data", "model_data", "LONGVARCHAR", false);

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