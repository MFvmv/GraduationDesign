package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InpatientsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InpatientsExample() {
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

    public InpatientsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public InpatientsExample orderBy(String ... orderByClauses) {
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
        InpatientsExample example = new InpatientsExample();
        return example.createCriteria();
    }

    public InpatientsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public InpatientsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public InpatientsExample distinct(boolean distinct) {
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

        public Criteria andInpatientIDIsNull() {
            addCriterion("InpatientID is null");
            return (Criteria) this;
        }

        public Criteria andInpatientIDIsNotNull() {
            addCriterion("InpatientID is not null");
            return (Criteria) this;
        }

        public Criteria andInpatientIDEqualTo(Integer value) {
            addCriterion("InpatientID =", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("InpatientID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDNotEqualTo(Integer value) {
            addCriterion("InpatientID <>", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDNotEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("InpatientID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDGreaterThan(Integer value) {
            addCriterion("InpatientID >", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDGreaterThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("InpatientID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("InpatientID >=", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDGreaterThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("InpatientID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDLessThan(Integer value) {
            addCriterion("InpatientID <", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDLessThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("InpatientID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDLessThanOrEqualTo(Integer value) {
            addCriterion("InpatientID <=", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDLessThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("InpatientID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDIn(List<Integer> values) {
            addCriterion("InpatientID in", values, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDNotIn(List<Integer> values) {
            addCriterion("InpatientID not in", values, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDBetween(Integer value1, Integer value2) {
            addCriterion("InpatientID between", value1, value2, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDNotBetween(Integer value1, Integer value2) {
            addCriterion("InpatientID not between", value1, value2, "InpatientID");
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

        public Criteria andPatientIDEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("PatientID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualTo(Integer value) {
            addCriterion("PatientID <>", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("PatientID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThan(Integer value) {
            addCriterion("PatientID >", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("PatientID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("PatientID >=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("PatientID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThan(Integer value) {
            addCriterion("PatientID <", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("PatientID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualTo(Integer value) {
            addCriterion("PatientID <=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualToColumn(Inpatients.Column column) {
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

        public Criteria andAdmissionDateIsNull() {
            addCriterion("AdmissionDate is null");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateIsNotNull() {
            addCriterion("AdmissionDate is not null");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateEqualTo(Date value) {
            addCriterionForJDBCDate("AdmissionDate =", value, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("AdmissionDate = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAdmissionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("AdmissionDate <>", value, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateNotEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("AdmissionDate <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAdmissionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("AdmissionDate >", value, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateGreaterThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("AdmissionDate > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAdmissionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AdmissionDate >=", value, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateGreaterThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("AdmissionDate >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAdmissionDateLessThan(Date value) {
            addCriterionForJDBCDate("AdmissionDate <", value, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateLessThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("AdmissionDate < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAdmissionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AdmissionDate <=", value, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateLessThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("AdmissionDate <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAdmissionDateIn(List<Date> values) {
            addCriterionForJDBCDate("AdmissionDate in", values, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("AdmissionDate not in", values, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AdmissionDate between", value1, value2, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andAdmissionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AdmissionDate not between", value1, value2, "AdmissionDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateIsNull() {
            addCriterion("DischargeDate is null");
            return (Criteria) this;
        }

        public Criteria andDischargeDateIsNotNull() {
            addCriterion("DischargeDate is not null");
            return (Criteria) this;
        }

        public Criteria andDischargeDateEqualTo(Date value) {
            addCriterionForJDBCDate("DischargeDate =", value, "DischargeDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("DischargeDate = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDischargeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("DischargeDate <>", value, "DischargeDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateNotEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("DischargeDate <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDischargeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("DischargeDate >", value, "DischargeDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateGreaterThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("DischargeDate > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDischargeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DischargeDate >=", value, "DischargeDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateGreaterThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("DischargeDate >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDischargeDateLessThan(Date value) {
            addCriterionForJDBCDate("DischargeDate <", value, "DischargeDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateLessThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("DischargeDate < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDischargeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DischargeDate <=", value, "DischargeDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateLessThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("DischargeDate <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDischargeDateIn(List<Date> values) {
            addCriterionForJDBCDate("DischargeDate in", values, "DischargeDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("DischargeDate not in", values, "DischargeDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DischargeDate between", value1, value2, "DischargeDate");
            return (Criteria) this;
        }

        public Criteria andDischargeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DischargeDate not between", value1, value2, "DischargeDate");
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

        public Criteria andRoomNumberEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("RoomNumber = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotEqualTo(String value) {
            addCriterion("RoomNumber <>", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("RoomNumber <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThan(String value) {
            addCriterion("RoomNumber >", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("RoomNumber > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThanOrEqualTo(String value) {
            addCriterion("RoomNumber >=", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("RoomNumber >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThan(String value) {
            addCriterion("RoomNumber <", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("RoomNumber < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThanOrEqualTo(String value) {
            addCriterion("RoomNumber <=", value, "RoomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThanOrEqualToColumn(Inpatients.Column column) {
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

        public Criteria andBedNumberEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("BedNumber = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberNotEqualTo(Integer value) {
            addCriterion("BedNumber <>", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberNotEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("BedNumber <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberGreaterThan(Integer value) {
            addCriterion("BedNumber >", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberGreaterThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("BedNumber > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("BedNumber >=", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberGreaterThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("BedNumber >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberLessThan(Integer value) {
            addCriterion("BedNumber <", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberLessThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("BedNumber < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBedNumberLessThanOrEqualTo(Integer value) {
            addCriterion("BedNumber <=", value, "BedNumber");
            return (Criteria) this;
        }

        public Criteria andBedNumberLessThanOrEqualToColumn(Inpatients.Column column) {
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

        public Criteria andCurrentStatusIsNull() {
            addCriterion("CurrentStatus is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusIsNotNull() {
            addCriterion("CurrentStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusEqualTo(String value) {
            addCriterion("CurrentStatus =", value, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("CurrentStatus = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrentStatusNotEqualTo(String value) {
            addCriterion("CurrentStatus <>", value, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusNotEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("CurrentStatus <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrentStatusGreaterThan(String value) {
            addCriterion("CurrentStatus >", value, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusGreaterThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("CurrentStatus > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CurrentStatus >=", value, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusGreaterThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("CurrentStatus >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrentStatusLessThan(String value) {
            addCriterion("CurrentStatus <", value, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusLessThanColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("CurrentStatus < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrentStatusLessThanOrEqualTo(String value) {
            addCriterion("CurrentStatus <=", value, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusLessThanOrEqualToColumn(Inpatients.Column column) {
            addCriterion(new StringBuilder("CurrentStatus <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCurrentStatusLike(String value) {
            addCriterion("CurrentStatus like", value, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusNotLike(String value) {
            addCriterion("CurrentStatus not like", value, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusIn(List<String> values) {
            addCriterion("CurrentStatus in", values, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusNotIn(List<String> values) {
            addCriterion("CurrentStatus not in", values, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusBetween(String value1, String value2) {
            addCriterion("CurrentStatus between", value1, value2, "CurrentStatus");
            return (Criteria) this;
        }

        public Criteria andCurrentStatusNotBetween(String value1, String value2) {
            addCriterion("CurrentStatus not between", value1, value2, "CurrentStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private InpatientsExample example;

        protected Criteria(InpatientsExample example) {
            super();
            this.example = example;
        }

        public InpatientsExample example() {
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
        void example(InpatientsExample example);
    }
}