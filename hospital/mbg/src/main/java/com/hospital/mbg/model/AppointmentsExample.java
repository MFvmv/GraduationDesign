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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andAppointmentTimeIsNull() {
            addCriterion("AppointmentTime is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIsNotNull() {
            addCriterion("AppointmentTime is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeEqualTo(Date value) {
            addCriterionForJDBCTime("AppointmentTime =", value, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentTime = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("AppointmentTime <>", value, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentTime <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("AppointmentTime >", value, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentTime > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("AppointmentTime >=", value, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentTime >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThan(Date value) {
            addCriterionForJDBCTime("AppointmentTime <", value, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentTime < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("AppointmentTime <=", value, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("AppointmentTime <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIn(List<Date> values) {
            addCriterionForJDBCTime("AppointmentTime in", values, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("AppointmentTime not in", values, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("AppointmentTime between", value1, value2, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("AppointmentTime not between", value1, value2, "AppointmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("Department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("Department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("Department =", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Department = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("Department <>", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Department <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("Department >", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Department > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("Department >=", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Department >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("Department <", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Department < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("Department <=", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("Department <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("Department like", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("Department not like", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("Department in", values, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("Department not in", values, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("Department between", value1, value2, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("Department not between", value1, value2, "Department");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNull() {
            addCriterion("DoctorName is null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNotNull() {
            addCriterion("DoctorName is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameEqualTo(String value) {
            addCriterion("DoctorName =", value, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorName = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotEqualTo(String value) {
            addCriterion("DoctorName <>", value, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorName <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThan(String value) {
            addCriterion("DoctorName >", value, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorName > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThanOrEqualTo(String value) {
            addCriterion("DoctorName >=", value, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorName >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThan(String value) {
            addCriterion("DoctorName <", value, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThanColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorName < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThanOrEqualTo(String value) {
            addCriterion("DoctorName <=", value, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThanOrEqualToColumn(Appointments.Column column) {
            addCriterion(new StringBuilder("DoctorName <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorNameLike(String value) {
            addCriterion("DoctorName like", value, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotLike(String value) {
            addCriterion("DoctorName not like", value, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIn(List<String> values) {
            addCriterion("DoctorName in", values, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotIn(List<String> values) {
            addCriterion("DoctorName not in", values, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameBetween(String value1, String value2) {
            addCriterion("DoctorName between", value1, value2, "DoctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotBetween(String value1, String value2) {
            addCriterion("DoctorName not between", value1, value2, "DoctorName");
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