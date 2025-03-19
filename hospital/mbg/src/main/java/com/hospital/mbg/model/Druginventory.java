package com.hospital.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Druginventory implements Serializable {
    @ApiModelProperty(value = "药品唯一标识")
    private Integer DrugID;

    @ApiModelProperty(value = "药品名称")
    private String DrugName;

    @ApiModelProperty(value = "药品类别")
    private String Category;

    @ApiModelProperty(value = "库存数量")
    private Integer Quantity;

    @ApiModelProperty(value = "单价")
    private BigDecimal UnitPrice;

    @ApiModelProperty(value = "供应商名称")
    private String SupplierName;

    @ApiModelProperty(value = "最后更新时间")
    private Date LastUpdated;

    @ApiModelProperty(value = "药品制作日期")
    private Date ManufactureDate;

    @ApiModelProperty(value = "药品有效日期")
    private Date ExpiryDate;

    private static final long serialVersionUID = 1L;

    public Integer getDrugID() {
        return DrugID;
    }

    public void setDrugID(Integer DrugID) {
        this.DrugID = DrugID;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String DrugName) {
        this.DrugName = DrugName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public BigDecimal getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(BigDecimal UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public Date getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(Date LastUpdated) {
        this.LastUpdated = LastUpdated;
    }

    public Date getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(Date ManufactureDate) {
        this.ManufactureDate = ManufactureDate;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", DrugID=").append(DrugID);
        sb.append(", DrugName=").append(DrugName);
        sb.append(", Category=").append(Category);
        sb.append(", Quantity=").append(Quantity);
        sb.append(", UnitPrice=").append(UnitPrice);
        sb.append(", SupplierName=").append(SupplierName);
        sb.append(", LastUpdated=").append(LastUpdated);
        sb.append(", ManufactureDate=").append(ManufactureDate);
        sb.append(", ExpiryDate=").append(ExpiryDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static enum Column {
        DrugID("DrugID", "DrugID", "INTEGER", false),
        DrugName("DrugName", "DrugName", "VARCHAR", false),
        Category("Category", "Category", "VARCHAR", false),
        Quantity("Quantity", "Quantity", "INTEGER", false),
        UnitPrice("UnitPrice", "UnitPrice", "DECIMAL", false),
        SupplierName("SupplierName", "SupplierName", "VARCHAR", false),
        LastUpdated("LastUpdated", "LastUpdated", "TIMESTAMP", false),
        ManufactureDate("ManufactureDate", "ManufactureDate", "DATE", false),
        ExpiryDate("ExpiryDate", "ExpiryDate", "DATE", false);

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