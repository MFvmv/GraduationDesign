package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AppointmentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppointmentsExample() {
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

    public AppointmentsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public AppointmentsExample orderBy(String ... orderByClauses) {
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
        AppointmentsExample example = new AppointmentsExample();
        return example.createCriteria();
    }

    public AppointmentsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public AppointmentsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public AppointmentsExample distinct(boolean distinct) {
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

        public Criteria andAppointmentIDIsNull() {
            addCriterion("AppointmentID is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDIsNotNull() {
            addCriterion("AppointmentID is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDEqualTo(Integer value) {
            addCriterion("AppointmentID =", value, "AppointmentID");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentIDNotEqualTo(Integer value) {
            addCriterion("AppointmentID <>", value, "AppointmentID");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentIDGreaterThan(Integer value) {
            addCriterion("AppointmentID >", value, "AppointmentID");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("AppointmentID >=", value, "AppointmentID");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentIDLessThan(Integer value) {
            addCriterion("AppointmentID <", value, "AppointmentID");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentIDLessThanOrEqualTo(Integer value) {
            addCriterion("AppointmentID <=", value, "AppointmentID");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDLessThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentIDIn(List<Integer> values) {
            addCriterion("AppointmentID in", values, "AppointmentID");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDNotIn(List<Integer> values) {
            addCriterion("AppointmentID not in", values, "AppointmentID");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDBetween(Integer value1, Integer value2) {
            addCriterion("AppointmentID between", value1, value2, "AppointmentID");
            return (Criteria) this;
        }

        public Criteria andAppointmentIDNotBetween(Integer value1, Integer value2) {
            addCriterion("AppointmentID not between", value1, value2, "AppointmentID");
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

        public Criteria andPatientIDEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("PatientID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualTo(Integer value) {
            addCriterion("PatientID <>", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("PatientID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThan(Integer value) {
            addCriterion("PatientID >", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("PatientID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("PatientID >=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("PatientID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThan(Integer value) {
            addCriterion("PatientID <", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("PatientID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualTo(Integer value) {
            addCriterion("PatientID <=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualToColumn(Appointments.Column column) {
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

        public Criteria andAppointmentDateIsNull() {
            addCriterion("AppointmentDate is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateIsNotNull() {
            addCriterion("AppointmentDate is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateEqualTo(Date value) {
            addCriterionForJDBCDate("AppointmentDate =", value, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentDate = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("AppointmentDate <>", value, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentDate <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentDateGreaterThan(Date value) {
            addCriterionForJDBCDate("AppointmentDate >", value, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentDate > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AppointmentDate >=", value, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentDate >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentDateLessThan(Date value) {
            addCriterionForJDBCDate("AppointmentDate <", value, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentDate < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AppointmentDate <=", value, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateLessThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentDate <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentDateIn(List<Date> values) {
            addCriterionForJDBCDate("AppointmentDate in", values, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("AppointmentDate not in", values, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AppointmentDate between", value1, value2, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AppointmentDate not between", value1, value2, "AppointmentDate");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionIsNull() {
            addCriterion("AppointmentSession is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionIsNotNull() {
            addCriterion("AppointmentSession is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionEqualTo(String value) {
            addCriterion("AppointmentSession =", value, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentSession = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionNotEqualTo(String value) {
            addCriterion("AppointmentSession <>", value, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentSession <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionGreaterThan(String value) {
            addCriterion("AppointmentSession >", value, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentSession > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionGreaterThanOrEqualTo(String value) {
            addCriterion("AppointmentSession >=", value, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentSession >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionLessThan(String value) {
            addCriterion("AppointmentSession <", value, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentSession < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionLessThanOrEqualTo(String value) {
            addCriterion("AppointmentSession <=", value, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionLessThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentSession <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionLike(String value) {
            addCriterion("AppointmentSession like", value, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionNotLike(String value) {
            addCriterion("AppointmentSession not like", value, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionIn(List<String> values) {
            addCriterion("AppointmentSession in", values, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionNotIn(List<String> values) {
            addCriterion("AppointmentSession not in", values, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionBetween(String value1, String value2) {
            addCriterion("AppointmentSession between", value1, value2, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andAppointmentSessionNotBetween(String value1, String value2) {
            addCriterion("AppointmentSession not between", value1, value2, "AppointmentSession");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("Status =", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Status = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("Status <>", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Status <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("Status >", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Status > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("Status >=", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Status >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("Status <", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Status < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("Status <=", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Status <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("Status like", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("Status not like", value, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("Status in", values, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("Status not in", values, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("Status between", value1, value2, "Status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("Status not between", value1, value2, "Status");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("CreatedAt is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("CreatedAt is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("CreatedAt =", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("CreatedAt = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("CreatedAt <>", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("CreatedAt <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("CreatedAt >", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("CreatedAt > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("CreatedAt >=", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("CreatedAt >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("CreatedAt <", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("CreatedAt < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("CreatedAt <=", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("CreatedAt <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("CreatedAt in", values, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("CreatedAt not in", values, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("CreatedAt between", value1, value2, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("CreatedAt not between", value1, value2, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andDoctorIDIsNull() {
            addCriterion("DoctorID is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIDIsNotNull() {
            addCriterion("DoctorID is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIDEqualTo(Integer value) {
            addCriterion("DoctorID =", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDNotEqualTo(Integer value) {
            addCriterion("DoctorID <>", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDGreaterThan(Integer value) {
            addCriterion("DoctorID >", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("DoctorID >=", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDLessThan(Integer value) {
            addCriterion("DoctorID <", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDLessThanOrEqualTo(Integer value) {
            addCriterion("DoctorID <=", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDLessThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDIn(List<Integer> values) {
            addCriterion("DoctorID in", values, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDNotIn(List<Integer> values) {
            addCriterion("DoctorID not in", values, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDBetween(Integer value1, Integer value2) {
            addCriterion("DoctorID between", value1, value2, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDNotBetween(Integer value1, Integer value2) {
            addCriterion("DoctorID not between", value1, value2, "DoctorID");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private AppointmentsExample example;

        protected Criteria(AppointmentsExample example) {
            super();
            this.example = example;
        }

        public AppointmentsExample example() {
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
        void example(AppointmentsExample example);
    }
}