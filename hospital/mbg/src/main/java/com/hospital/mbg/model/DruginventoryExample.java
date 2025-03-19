package com.hospital.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DruginventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DruginventoryExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DruginventoryExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public DruginventoryExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        DruginventoryExample example = new DruginventoryExample();
        return example.createCriteria();
    }

    public DruginventoryExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public DruginventoryExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public DruginventoryExample distinct(boolean distinct) {
        this.setDistinct(distinct);
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDrugIDIsNull() {
            addCriterion("DrugID is null");
            return (Criteria) this;
        }

        public Criteria andDrugIDIsNotNull() {
            addCriterion("DrugID is not null");
            return (Criteria) this;
        }

        public Criteria andDrugIDEqualTo(Integer value) {
            addCriterion("DrugID =", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDNotEqualTo(Integer value) {
            addCriterion("DrugID <>", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDNotEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDGreaterThan(Integer value) {
            addCriterion("DrugID >", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDGreaterThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("DrugID >=", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDGreaterThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDLessThan(Integer value) {
            addCriterion("DrugID <", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDLessThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDLessThanOrEqualTo(Integer value) {
            addCriterion("DrugID <=", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDLessThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDIn(List<Integer> values) {
            addCriterion("DrugID in", values, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDNotIn(List<Integer> values) {
            addCriterion("DrugID not in", values, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDBetween(Integer value1, Integer value2) {
            addCriterion("DrugID between", value1, value2, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDNotBetween(Integer value1, Integer value2) {
            addCriterion("DrugID not between", value1, value2, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugNameIsNull() {
            addCriterion("DrugName is null");
            return (Criteria) this;
        }

        public Criteria andDrugNameIsNotNull() {
            addCriterion("DrugName is not null");
            return (Criteria) this;
        }

        public Criteria andDrugNameEqualTo(String value) {
            addCriterion("DrugName =", value, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugName = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugNameNotEqualTo(String value) {
            addCriterion("DrugName <>", value, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugName <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThan(String value) {
            addCriterion("DrugName >", value, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugName > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThanOrEqualTo(String value) {
            addCriterion("DrugName >=", value, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugName >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThan(String value) {
            addCriterion("DrugName <", value, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugName < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThanOrEqualTo(String value) {
            addCriterion("DrugName <=", value, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("DrugName <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugNameLike(String value) {
            addCriterion("DrugName like", value, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotLike(String value) {
            addCriterion("DrugName not like", value, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameIn(List<String> values) {
            addCriterion("DrugName in", values, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotIn(List<String> values) {
            addCriterion("DrugName not in", values, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameBetween(String value1, String value2) {
            addCriterion("DrugName between", value1, value2, "DrugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotBetween(String value1, String value2) {
            addCriterion("DrugName not between", value1, value2, "DrugName");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("Category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("Category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("Category =", value, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Category = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("Category <>", value, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Category <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("Category >", value, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Category > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("Category >=", value, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Category >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("Category <", value, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Category < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("Category <=", value, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Category <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("Category like", value, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("Category not like", value, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("Category in", values, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("Category not in", values, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("Category between", value1, value2, "Category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("Category not between", value1, value2, "Category");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("Quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("Quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("Quantity =", value, "Quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Quantity = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("Quantity <>", value, "Quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Quantity <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("Quantity >", value, "Quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Quantity > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("Quantity >=", value, "Quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Quantity >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("Quantity <", value, "Quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Quantity < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("Quantity <=", value, "Quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("Quantity <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("Quantity in", values, "Quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("Quantity not in", values, "Quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("Quantity between", value1, value2, "Quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("Quantity not between", value1, value2, "Quantity");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("UnitPrice is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("UnitPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("UnitPrice =", value, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("UnitPrice = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("UnitPrice <>", value, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("UnitPrice <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("UnitPrice >", value, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("UnitPrice > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UnitPrice >=", value, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("UnitPrice >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("UnitPrice <", value, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("UnitPrice < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UnitPrice <=", value, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("UnitPrice <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("UnitPrice in", values, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("UnitPrice not in", values, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UnitPrice between", value1, value2, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UnitPrice not between", value1, value2, "UnitPrice");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNull() {
            addCriterion("SupplierName is null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNotNull() {
            addCriterion("SupplierName is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameEqualTo(String value) {
            addCriterion("SupplierName =", value, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("SupplierName = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotEqualTo(String value) {
            addCriterion("SupplierName <>", value, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("SupplierName <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThan(String value) {
            addCriterion("SupplierName >", value, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("SupplierName > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("SupplierName >=", value, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("SupplierName >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThan(String value) {
            addCriterion("SupplierName <", value, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("SupplierName < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThanOrEqualTo(String value) {
            addCriterion("SupplierName <=", value, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("SupplierName <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSupplierNameLike(String value) {
            addCriterion("SupplierName like", value, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotLike(String value) {
            addCriterion("SupplierName not like", value, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIn(List<String> values) {
            addCriterion("SupplierName in", values, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotIn(List<String> values) {
            addCriterion("SupplierName not in", values, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameBetween(String value1, String value2) {
            addCriterion("SupplierName between", value1, value2, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotBetween(String value1, String value2) {
            addCriterion("SupplierName not between", value1, value2, "SupplierName");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNull() {
            addCriterion("LastUpdated is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNotNull() {
            addCriterion("LastUpdated is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedEqualTo(Date value) {
            addCriterion("LastUpdated =", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("LastUpdated = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualTo(Date value) {
            addCriterion("LastUpdated <>", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("LastUpdated <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThan(Date value) {
            addCriterion("LastUpdated >", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("LastUpdated > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("LastUpdated >=", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("LastUpdated >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThan(Date value) {
            addCriterion("LastUpdated <", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("LastUpdated < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("LastUpdated <=", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("LastUpdated <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIn(List<Date> values) {
            addCriterion("LastUpdated in", values, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotIn(List<Date> values) {
            addCriterion("LastUpdated not in", values, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedBetween(Date value1, Date value2) {
            addCriterion("LastUpdated between", value1, value2, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("LastUpdated not between", value1, value2, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIsNull() {
            addCriterion("ManufactureDate is null");
            return (Criteria) this;
        }

        public Criteria andManufactureDateIsNotNull() {
            addCriterion("ManufactureDate is not null");
            return (Criteria) this;
        }

        public Criteria andManufactureDateEqualTo(Date value) {
            addCriterionForJDBCDate("ManufactureDate =", value, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ManufactureDate = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ManufactureDate <>", value, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ManufactureDate <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ManufactureDate >", value, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ManufactureDate > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ManufactureDate >=", value, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateGreaterThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ManufactureDate >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThan(Date value) {
            addCriterionForJDBCDate("ManufactureDate <", value, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ManufactureDate < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ManufactureDate <=", value, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateLessThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ManufactureDate <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andManufactureDateIn(List<Date> values) {
            addCriterionForJDBCDate("ManufactureDate in", values, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ManufactureDate not in", values, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ManufactureDate between", value1, value2, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andManufactureDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ManufactureDate not between", value1, value2, "ManufactureDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIsNull() {
            addCriterion("ExpiryDate is null");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIsNotNull() {
            addCriterion("ExpiryDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpiryDateEqualTo(Date value) {
            addCriterionForJDBCDate("ExpiryDate =", value, "ExpiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ExpiryDate = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ExpiryDate <>", value, "ExpiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ExpiryDate <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ExpiryDate >", value, "ExpiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ExpiryDate > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ExpiryDate >=", value, "ExpiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ExpiryDate >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThan(Date value) {
            addCriterionForJDBCDate("ExpiryDate <", value, "ExpiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThanColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ExpiryDate < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ExpiryDate <=", value, "ExpiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThanOrEqualToColumn(Druginventory.Column column) {
            addCriterion(new StringBuilder("ExpiryDate <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andExpiryDateIn(List<Date> values) {
            addCriterionForJDBCDate("ExpiryDate in", values, "ExpiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ExpiryDate not in", values, "ExpiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ExpiryDate between", value1, value2, "ExpiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ExpiryDate not between", value1, value2, "ExpiryDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private DruginventoryExample example;

        protected Criteria(DruginventoryExample example) {
            super();
            this.example = example;
        }

        public DruginventoryExample example() {
            return this.example;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(DruginventoryExample example);
    }
}