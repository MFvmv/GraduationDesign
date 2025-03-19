package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HospitalbedsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HospitalbedsExample() {
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

    public HospitalbedsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public HospitalbedsExample orderBy(String ... orderByClauses) {
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
        HospitalbedsExample example = new HospitalbedsExample();
        return example.createCriteria();
    }

    public HospitalbedsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public HospitalbedsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public HospitalbedsExample distinct(boolean distinct) {
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

        public Criteria andBedIDIsNull() {
            addCriterion("BedID is null");
            return (Criteria) this;
        }

        public Criteria andBedIDIsNotNull() {
            addCriterion("BedID is not null");
            return (Criteria) this;
        }

        public Criteria andBedIDEqualTo(Integer value) {
            addCriterion("BedID =", value, "BedID");
            return (Criteria) this;
        }

        public Criteria andBedIDEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedIDNotEqualTo(Integer value) {
            addCriterion("BedID <>", value, "BedID");
            return (Criteria) this;
        }

        public Criteria andBedIDNotEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedIDGreaterThan(Integer value) {
            addCriterion("BedID >", value, "BedID");
            return (Criteria) this;
        }

        public Criteria andBedIDGreaterThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("BedID >=", value, "BedID");
            return (Criteria) this;
        }

        public Criteria andBedIDGreaterThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedIDLessThan(Integer value) {
            addCriterion("BedID <", value, "BedID");
            return (Criteria) this;
        }

        public Criteria andBedIDLessThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedIDLessThanOrEqualTo(Integer value) {
            addCriterion("BedID <=", value, "BedID");
            return (Criteria) this;
        }

        public Criteria andBedIDLessThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedIDIn(List<Integer> values) {
            addCriterion("BedID in", values, "BedID");
            return (Criteria) this;
        }

        public Criteria andBedIDNotIn(List<Integer> values) {
            addCriterion("BedID not in", values, "BedID");
            return (Criteria) this;
        }

        public Criteria andBedIDBetween(Integer value1, Integer value2) {
            addCriterion("BedID between", value1, value2, "BedID");
            return (Criteria) this;
        }

        public Criteria andBedIDNotBetween(Integer value1, Integer value2) {
            addCriterion("BedID not between", value1, value2, "BedID");
            return (Criteria) this;
        }

        public Criteria andRoomNumberIsNull() {
            addCriterion("RoomNumber is null");
            return (Criteria) this;
        }

        public Criteria andRoomNumberIsNotNull() {
            addCriterion("RoomNumber is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNumberEqualTo(String value) {
            addCriterion("RoomNumber =", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("RoomNumber = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotEqualTo(String value) {
            addCriterion("RoomNumber <>", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("RoomNumber <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThan(String value) {
            addCriterion("RoomNumber >", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("RoomNumber > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThanOrEqualTo(String value) {
            addCriterion("RoomNumber >=", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("RoomNumber >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThan(String value) {
            addCriterion("RoomNumber <", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("RoomNumber < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThanOrEqualTo(String value) {
            addCriterion("RoomNumber <=", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("RoomNumber <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberLike(String value) {
            addCriterion("RoomNumber like", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotLike(String value) {
            addCriterion("RoomNumber not like", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberIn(List<String> values) {
            addCriterion("RoomNumber in", values, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotIn(List<String> values) {
            addCriterion("RoomNumber not in", values, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberBetween(String value1, String value2) {
            addCriterion("RoomNumber between", value1, value2, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotBetween(String value1, String value2) {
            addCriterion("RoomNumber not between", value1, value2, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberIsNull() {
            addCriterion("BedNumber is null");
            return (Criteria) this;
        }

        public Criteria andBedNumberIsNotNull() {
            addCriterion("BedNumber is not null");
            return (Criteria) this;
        }

        public Criteria andBedNumberEqualTo(Integer value) {
            addCriterion("BedNumber =", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedNumber = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberNotEqualTo(Integer value) {
            addCriterion("BedNumber <>", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberNotEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedNumber <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberGreaterThan(Integer value) {
            addCriterion("BedNumber >", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberGreaterThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedNumber > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("BedNumber >=", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberGreaterThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedNumber >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberLessThan(Integer value) {
            addCriterion("BedNumber <", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberLessThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedNumber < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberLessThanOrEqualTo(Integer value) {
            addCriterion("BedNumber <=", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberLessThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedNumber <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberIn(List<Integer> values) {
            addCriterion("BedNumber in", values, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberNotIn(List<Integer> values) {
            addCriterion("BedNumber not in", values, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberBetween(Integer value1, Integer value2) {
            addCriterion("BedNumber between", value1, value2, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("BedNumber not between", value1, value2, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedStatusIsNull() {
            addCriterion("BedStatus is null");
            return (Criteria) this;
        }

        public Criteria andBedStatusIsNotNull() {
            addCriterion("BedStatus is not null");
            return (Criteria) this;
        }

        public Criteria andBedStatusEqualTo(String value) {
            addCriterion("BedStatus =", value, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedStatus = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedStatusNotEqualTo(String value) {
            addCriterion("BedStatus <>", value, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusNotEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedStatus <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedStatusGreaterThan(String value) {
            addCriterion("BedStatus >", value, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusGreaterThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedStatus > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedStatusGreaterThanOrEqualTo(String value) {
            addCriterion("BedStatus >=", value, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusGreaterThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedStatus >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedStatusLessThan(String value) {
            addCriterion("BedStatus <", value, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusLessThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedStatus < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedStatusLessThanOrEqualTo(String value) {
            addCriterion("BedStatus <=", value, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusLessThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("BedStatus <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedStatusLike(String value) {
            addCriterion("BedStatus like", value, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusNotLike(String value) {
            addCriterion("BedStatus not like", value, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusIn(List<String> values) {
            addCriterion("BedStatus in", values, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusNotIn(List<String> values) {
            addCriterion("BedStatus not in", values, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusBetween(String value1, String value2) {
            addCriterion("BedStatus between", value1, value2, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andBedStatusNotBetween(String value1, String value2) {
            addCriterion("BedStatus not between", value1, value2, "BedStatus");
            return (Criteria) this;
        }

        public Criteria andPatientIDIsNull() {
            addCriterion("PatientID is null");
            return (Criteria) this;
        }

        public Criteria andPatientIDIsNotNull() {
            addCriterion("PatientID is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIDEqualTo(Integer value) {
            addCriterion("PatientID =", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("PatientID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualTo(Integer value) {
            addCriterion("PatientID <>", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("PatientID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThan(Integer value) {
            addCriterion("PatientID >", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("PatientID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("PatientID >=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("PatientID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThan(Integer value) {
            addCriterion("PatientID <", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("PatientID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualTo(Integer value) {
            addCriterion("PatientID <=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("PatientID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDIn(List<Integer> values) {
            addCriterion("PatientID in", values, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDNotIn(List<Integer> values) {
            addCriterion("PatientID not in", values, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDBetween(Integer value1, Integer value2) {
            addCriterion("PatientID between", value1, value2, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDNotBetween(Integer value1, Integer value2) {
            addCriterion("PatientID not between", value1, value2, "PatientID");
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

        public Criteria andLastUpdatedEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("LastUpdated = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualTo(Date value) {
            addCriterion("LastUpdated <>", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("LastUpdated <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThan(Date value) {
            addCriterion("LastUpdated >", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("LastUpdated > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("LastUpdated >=", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualToColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("LastUpdated >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThan(Date value) {
            addCriterion("LastUpdated <", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanColumn(Hospitalbeds.Column column) {
            addCriterion(new StringBuilder("LastUpdated < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("LastUpdated <=", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualToColumn(Hospitalbeds.Column column) {
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
    }

    public static class Criteria extends GeneratedCriteria {
        private HospitalbedsExample example;

        protected Criteria(HospitalbedsExample example) {
            super();
            this.example = example;
        }

        public HospitalbedsExample example() {
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
        void example(HospitalbedsExample example);
    }
}