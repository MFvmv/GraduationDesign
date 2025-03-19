package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalrecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedicalrecordsExample() {
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

    public MedicalrecordsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public MedicalrecordsExample orderBy(String ... orderByClauses) {
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
        MedicalrecordsExample example = new MedicalrecordsExample();
        return example.createCriteria();
    }

    public MedicalrecordsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public MedicalrecordsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public MedicalrecordsExample distinct(boolean distinct) {
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

        public Criteria andRecordIDIsNull() {
            addCriterion("RecordID is null");
            return (Criteria) this;
        }

        public Criteria andRecordIDIsNotNull() {
            addCriterion("RecordID is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIDEqualTo(Integer value) {
            addCriterion("RecordID =", value, "RecordID");
            return (Criteria) this;
        }

        public Criteria andRecordIDEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordIDNotEqualTo(Integer value) {
            addCriterion("RecordID <>", value, "RecordID");
            return (Criteria) this;
        }

        public Criteria andRecordIDNotEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordIDGreaterThan(Integer value) {
            addCriterion("RecordID >", value, "RecordID");
            return (Criteria) this;
        }

        public Criteria andRecordIDGreaterThanColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("RecordID >=", value, "RecordID");
            return (Criteria) this;
        }

        public Criteria andRecordIDGreaterThanOrEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordIDLessThan(Integer value) {
            addCriterion("RecordID <", value, "RecordID");
            return (Criteria) this;
        }

        public Criteria andRecordIDLessThanColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordIDLessThanOrEqualTo(Integer value) {
            addCriterion("RecordID <=", value, "RecordID");
            return (Criteria) this;
        }

        public Criteria andRecordIDLessThanOrEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordIDIn(List<Integer> values) {
            addCriterion("RecordID in", values, "RecordID");
            return (Criteria) this;
        }

        public Criteria andRecordIDNotIn(List<Integer> values) {
            addCriterion("RecordID not in", values, "RecordID");
            return (Criteria) this;
        }

        public Criteria andRecordIDBetween(Integer value1, Integer value2) {
            addCriterion("RecordID between", value1, value2, "RecordID");
            return (Criteria) this;
        }

        public Criteria andRecordIDNotBetween(Integer value1, Integer value2) {
            addCriterion("RecordID not between", value1, value2, "RecordID");
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

        public Criteria andPatientIDEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("PatientID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualTo(Integer value) {
            addCriterion("PatientID <>", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("PatientID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThan(Integer value) {
            addCriterion("PatientID >", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("PatientID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("PatientID >=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("PatientID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThan(Integer value) {
            addCriterion("PatientID <", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("PatientID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualTo(Integer value) {
            addCriterion("PatientID <=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualToColumn(Medicalrecords.Column column) {
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

        public Criteria andRecordDateIsNull() {
            addCriterion("RecordDate is null");
            return (Criteria) this;
        }

        public Criteria andRecordDateIsNotNull() {
            addCriterion("RecordDate is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDateEqualTo(Date value) {
            addCriterion("RecordDate =", value, "RecordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordDate = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordDateNotEqualTo(Date value) {
            addCriterion("RecordDate <>", value, "RecordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordDate <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThan(Date value) {
            addCriterion("RecordDate >", value, "RecordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThanColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordDate > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThanOrEqualTo(Date value) {
            addCriterion("RecordDate >=", value, "RecordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThanOrEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordDate >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThan(Date value) {
            addCriterion("RecordDate <", value, "RecordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThanColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordDate < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThanOrEqualTo(Date value) {
            addCriterion("RecordDate <=", value, "RecordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThanOrEqualToColumn(Medicalrecords.Column column) {
            addCriterion(new StringBuilder("RecordDate <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRecordDateIn(List<Date> values) {
            addCriterion("RecordDate in", values, "RecordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotIn(List<Date> values) {
            addCriterion("RecordDate not in", values, "RecordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateBetween(Date value1, Date value2) {
            addCriterion("RecordDate between", value1, value2, "RecordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotBetween(Date value1, Date value2) {
            addCriterion("RecordDate not between", value1, value2, "RecordDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private MedicalrecordsExample example;

        protected Criteria(MedicalrecordsExample example) {
            super();
            this.example = example;
        }

        public MedicalrecordsExample example() {
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
        void example(MedicalrecordsExample example);
    }
}