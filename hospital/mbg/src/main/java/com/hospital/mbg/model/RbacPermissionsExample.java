package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class RbacPermissionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbacPermissionsExample() {
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

    public RbacPermissionsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public RbacPermissionsExample orderBy(String ... orderByClauses) {
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
        RbacPermissionsExample example = new RbacPermissionsExample();
        return example.createCriteria();
    }

    public RbacPermissionsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public RbacPermissionsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public RbacPermissionsExample distinct(boolean distinct) {
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

        public Criteria andPermission_idIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermission_idIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermission_idEqualTo(Integer value) {
            addCriterion("permission_id =", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_idNotEqualTo(Integer value) {
            addCriterion("permission_id <>", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idNotEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_idGreaterThan(Integer value) {
            addCriterion("permission_id >", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idGreaterThanColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_id >=", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idGreaterThanOrEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_idLessThan(Integer value) {
            addCriterion("permission_id <", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idLessThanColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_idLessThanOrEqualTo(Integer value) {
            addCriterion("permission_id <=", value, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idLessThanOrEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_idIn(List<Integer> values) {
            addCriterion("permission_id in", values, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idNotIn(List<Integer> values) {
            addCriterion("permission_id not in", values, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idBetween(Integer value1, Integer value2) {
            addCriterion("permission_id between", value1, value2, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_idNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_id not between", value1, value2, "permission_id");
            return (Criteria) this;
        }

        public Criteria andPermission_nameIsNull() {
            addCriterion("permission_name is null");
            return (Criteria) this;
        }

        public Criteria andPermission_nameIsNotNull() {
            addCriterion("permission_name is not null");
            return (Criteria) this;
        }

        public Criteria andPermission_nameEqualTo(String value) {
            addCriterion("permission_name =", value, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_nameNotEqualTo(String value) {
            addCriterion("permission_name <>", value, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameNotEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_nameGreaterThan(String value) {
            addCriterion("permission_name >", value, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameGreaterThanColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_nameGreaterThanOrEqualTo(String value) {
            addCriterion("permission_name >=", value, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameGreaterThanOrEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_nameLessThan(String value) {
            addCriterion("permission_name <", value, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameLessThanColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_nameLessThanOrEqualTo(String value) {
            addCriterion("permission_name <=", value, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameLessThanOrEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("permission_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPermission_nameLike(String value) {
            addCriterion("permission_name like", value, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameNotLike(String value) {
            addCriterion("permission_name not like", value, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameIn(List<String> values) {
            addCriterion("permission_name in", values, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameNotIn(List<String> values) {
            addCriterion("permission_name not in", values, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameBetween(String value1, String value2) {
            addCriterion("permission_name between", value1, value2, "permission_name");
            return (Criteria) this;
        }

        public Criteria andPermission_nameNotBetween(String value1, String value2) {
            addCriterion("permission_name not between", value1, value2, "permission_name");
            return (Criteria) this;
        }

        public Criteria andResourceIsNull() {
            addCriterion("resource is null");
            return (Criteria) this;
        }

        public Criteria andResourceIsNotNull() {
            addCriterion("resource is not null");
            return (Criteria) this;
        }

        public Criteria andResourceEqualTo(String value) {
            addCriterion("resource =", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("resource = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andResourceNotEqualTo(String value) {
            addCriterion("resource <>", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("resource <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThan(String value) {
            addCriterion("resource >", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThanColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("resource > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThanOrEqualTo(String value) {
            addCriterion("resource >=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThanOrEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("resource >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andResourceLessThan(String value) {
            addCriterion("resource <", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThanColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("resource < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andResourceLessThanOrEqualTo(String value) {
            addCriterion("resource <=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThanOrEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("resource <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andResourceLike(String value) {
            addCriterion("resource like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotLike(String value) {
            addCriterion("resource not like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceIn(List<String> values) {
            addCriterion("resource in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotIn(List<String> values) {
            addCriterion("resource not in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceBetween(String value1, String value2) {
            addCriterion("resource between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotBetween(String value1, String value2) {
            addCriterion("resource not between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andActionIsNull() {
            addCriterion("action is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("action is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(String value) {
            addCriterion("action =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("action = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(String value) {
            addCriterion("action <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("action <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(String value) {
            addCriterion("action >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("action > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(String value) {
            addCriterion("action >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("action >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andActionLessThan(String value) {
            addCriterion("action <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("action < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(String value) {
            addCriterion("action <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualToColumn(RbacPermissions.Column column) {
            addCriterion(new StringBuilder("action <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andActionLike(String value) {
            addCriterion("action like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotLike(String value) {
            addCriterion("action not like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<String> values) {
            addCriterion("action in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<String> values) {
            addCriterion("action not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(String value1, String value2) {
            addCriterion("action between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(String value1, String value2) {
            addCriterion("action not between", value1, value2, "action");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private RbacPermissionsExample example;

        protected Criteria(RbacPermissionsExample example) {
            super();
            this.example = example;
        }

        public RbacPermissionsExample example() {
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
        void example(RbacPermissionsExample example);
    }
}