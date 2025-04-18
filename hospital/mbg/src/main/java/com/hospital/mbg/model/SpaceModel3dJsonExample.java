package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpaceModel3dJsonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpaceModel3dJsonExample() {
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

    public SpaceModel3dJsonExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public SpaceModel3dJsonExample orderBy(String ... orderByClauses) {
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
        SpaceModel3dJsonExample example = new SpaceModel3dJsonExample();
        return example.createCriteria();
    }

    public SpaceModel3dJsonExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public SpaceModel3dJsonExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public SpaceModel3dJsonExample distinct(boolean distinct) {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBed_idIsNull() {
            addCriterion("bed_id is null");
            return (Criteria) this;
        }

        public Criteria andBed_idIsNotNull() {
            addCriterion("bed_id is not null");
            return (Criteria) this;
        }

        public Criteria andBed_idEqualTo(Integer value) {
            addCriterion("bed_id =", value, "bed_id");
            return (Criteria) this;
        }

        public Criteria andBed_idEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("bed_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBed_idNotEqualTo(Integer value) {
            addCriterion("bed_id <>", value, "bed_id");
            return (Criteria) this;
        }

        public Criteria andBed_idNotEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("bed_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBed_idGreaterThan(Integer value) {
            addCriterion("bed_id >", value, "bed_id");
            return (Criteria) this;
        }

        public Criteria andBed_idGreaterThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("bed_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBed_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("bed_id >=", value, "bed_id");
            return (Criteria) this;
        }

        public Criteria andBed_idGreaterThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("bed_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBed_idLessThan(Integer value) {
            addCriterion("bed_id <", value, "bed_id");
            return (Criteria) this;
        }

        public Criteria andBed_idLessThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("bed_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBed_idLessThanOrEqualTo(Integer value) {
            addCriterion("bed_id <=", value, "bed_id");
            return (Criteria) this;
        }

        public Criteria andBed_idLessThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("bed_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBed_idIn(List<Integer> values) {
            addCriterion("bed_id in", values, "bed_id");
            return (Criteria) this;
        }

        public Criteria andBed_idNotIn(List<Integer> values) {
            addCriterion("bed_id not in", values, "bed_id");
            return (Criteria) this;
        }

        public Criteria andBed_idBetween(Integer value1, Integer value2) {
            addCriterion("bed_id between", value1, value2, "bed_id");
            return (Criteria) this;
        }

        public Criteria andBed_idNotBetween(Integer value1, Integer value2) {
            addCriterion("bed_id not between", value1, value2, "bed_id");
            return (Criteria) this;
        }

        public Criteria andFloor_numberIsNull() {
            addCriterion("floor_number is null");
            return (Criteria) this;
        }

        public Criteria andFloor_numberIsNotNull() {
            addCriterion("floor_number is not null");
            return (Criteria) this;
        }

        public Criteria andFloor_numberEqualTo(Integer value) {
            addCriterion("floor_number =", value, "floor_number");
            return (Criteria) this;
        }

        public Criteria andFloor_numberEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("floor_number = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFloor_numberNotEqualTo(Integer value) {
            addCriterion("floor_number <>", value, "floor_number");
            return (Criteria) this;
        }

        public Criteria andFloor_numberNotEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("floor_number <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFloor_numberGreaterThan(Integer value) {
            addCriterion("floor_number >", value, "floor_number");
            return (Criteria) this;
        }

        public Criteria andFloor_numberGreaterThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("floor_number > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFloor_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("floor_number >=", value, "floor_number");
            return (Criteria) this;
        }

        public Criteria andFloor_numberGreaterThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("floor_number >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFloor_numberLessThan(Integer value) {
            addCriterion("floor_number <", value, "floor_number");
            return (Criteria) this;
        }

        public Criteria andFloor_numberLessThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("floor_number < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFloor_numberLessThanOrEqualTo(Integer value) {
            addCriterion("floor_number <=", value, "floor_number");
            return (Criteria) this;
        }

        public Criteria andFloor_numberLessThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("floor_number <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFloor_numberIn(List<Integer> values) {
            addCriterion("floor_number in", values, "floor_number");
            return (Criteria) this;
        }

        public Criteria andFloor_numberNotIn(List<Integer> values) {
            addCriterion("floor_number not in", values, "floor_number");
            return (Criteria) this;
        }

        public Criteria andFloor_numberBetween(Integer value1, Integer value2) {
            addCriterion("floor_number between", value1, value2, "floor_number");
            return (Criteria) this;
        }

        public Criteria andFloor_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("floor_number not between", value1, value2, "floor_number");
            return (Criteria) this;
        }

        public Criteria andCreated_atIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreated_atIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_atEqualTo(Date value) {
            addCriterion("created_at =", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("created_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("created_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThan(Date value) {
            addCriterion("created_at >", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("created_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("created_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThan(Date value) {
            addCriterion("created_at <", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("created_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("created_at <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atIn(List<Date> values) {
            addCriterion("created_at in", values, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "created_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdated_atEqualTo(Date value) {
            addCriterion("updated_at =", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("updated_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("updated_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("updated_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("updated_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThan(Date value) {
            addCriterion("updated_at <", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThanColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("updated_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThanOrEqualToColumn(SpaceModel3dJson.Column column) {
            addCriterion(new StringBuilder("updated_at <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atIn(List<Date> values) {
            addCriterion("updated_at in", values, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updated_at");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private SpaceModel3dJsonExample example;

        protected Criteria(SpaceModel3dJsonExample example) {
            super();
            this.example = example;
        }

        public SpaceModel3dJsonExample example() {
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
        void example(SpaceModel3dJsonExample example);
    }
}