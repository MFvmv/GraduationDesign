package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PatientsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatientsExample() {
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

    public PatientsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public PatientsExample orderBy(String ... orderByClauses) {
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
        PatientsExample example = new PatientsExample();
        return example.createCriteria();
    }

    public PatientsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public PatientsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public PatientsExample distinct(boolean distinct) {
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

        public Criteria andPatientIDEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("PatientID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualTo(Integer value) {
            addCriterion("PatientID <>", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("PatientID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThan(Integer value) {
            addCriterion("PatientID >", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("PatientID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("PatientID >=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("PatientID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThan(Integer value) {
            addCriterion("PatientID <", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("PatientID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualTo(Integer value) {
            addCriterion("PatientID <=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualToColumn(Patients.Column column) {
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

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "Name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "Name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "Name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "Name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("Gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("Gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("Gender =", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Gender = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("Gender <>", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Gender <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("Gender >", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Gender > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("Gender >=", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Gender >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("Gender <", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Gender < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("Gender <=", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("Gender <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("Gender like", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("Gender not like", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("Gender in", values, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("Gender not in", values, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("Gender between", value1, value2, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("Gender not between", value1, value2, "Gender");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthIsNull() {
            addCriterion("DateOfBirth is null");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthIsNotNull() {
            addCriterion("DateOfBirth is not null");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthEqualTo(Date value) {
            addCriterionForJDBCDate("DateOfBirth =", value, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("DateOfBirth = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateOfBirthNotEqualTo(Date value) {
            addCriterionForJDBCDate("DateOfBirth <>", value, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("DateOfBirth <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateOfBirthGreaterThan(Date value) {
            addCriterionForJDBCDate("DateOfBirth >", value, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("DateOfBirth > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateOfBirthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DateOfBirth >=", value, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("DateOfBirth >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateOfBirthLessThan(Date value) {
            addCriterionForJDBCDate("DateOfBirth <", value, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("DateOfBirth < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateOfBirthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DateOfBirth <=", value, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthLessThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("DateOfBirth <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDateOfBirthIn(List<Date> values) {
            addCriterionForJDBCDate("DateOfBirth in", values, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthNotIn(List<Date> values) {
            addCriterionForJDBCDate("DateOfBirth not in", values, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DateOfBirth between", value1, value2, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andDateOfBirthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DateOfBirth not between", value1, value2, "DateOfBirth");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNull() {
            addCriterion("ContactNumber is null");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNotNull() {
            addCriterion("ContactNumber is not null");
            return (Criteria) this;
        }

        public Criteria andContactNumberEqualTo(String value) {
            addCriterion("ContactNumber =", value, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("ContactNumber = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContactNumberNotEqualTo(String value) {
            addCriterion("ContactNumber <>", value, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("ContactNumber <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThan(String value) {
            addCriterion("ContactNumber >", value, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("ContactNumber > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ContactNumber >=", value, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("ContactNumber >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThan(String value) {
            addCriterion("ContactNumber <", value, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("ContactNumber < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThanOrEqualTo(String value) {
            addCriterion("ContactNumber <=", value, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("ContactNumber <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContactNumberLike(String value) {
            addCriterion("ContactNumber like", value, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotLike(String value) {
            addCriterion("ContactNumber not like", value, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberIn(List<String> values) {
            addCriterion("ContactNumber in", values, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotIn(List<String> values) {
            addCriterion("ContactNumber not in", values, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberBetween(String value1, String value2) {
            addCriterion("ContactNumber between", value1, value2, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotBetween(String value1, String value2) {
            addCriterion("ContactNumber not between", value1, value2, "ContactNumber");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactIsNull() {
            addCriterion("EmergencyContact is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactIsNotNull() {
            addCriterion("EmergencyContact is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactEqualTo(String value) {
            addCriterion("EmergencyContact =", value, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("EmergencyContact = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmergencyContactNotEqualTo(String value) {
            addCriterion("EmergencyContact <>", value, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("EmergencyContact <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmergencyContactGreaterThan(String value) {
            addCriterion("EmergencyContact >", value, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("EmergencyContact > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmergencyContactGreaterThanOrEqualTo(String value) {
            addCriterion("EmergencyContact >=", value, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("EmergencyContact >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmergencyContactLessThan(String value) {
            addCriterion("EmergencyContact <", value, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("EmergencyContact < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmergencyContactLessThanOrEqualTo(String value) {
            addCriterion("EmergencyContact <=", value, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactLessThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("EmergencyContact <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmergencyContactLike(String value) {
            addCriterion("EmergencyContact like", value, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactNotLike(String value) {
            addCriterion("EmergencyContact not like", value, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactIn(List<String> values) {
            addCriterion("EmergencyContact in", values, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactNotIn(List<String> values) {
            addCriterion("EmergencyContact not in", values, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactBetween(String value1, String value2) {
            addCriterion("EmergencyContact between", value1, value2, "EmergencyContact");
            return (Criteria) this;
        }

        public Criteria andEmergencyContactNotBetween(String value1, String value2) {
            addCriterion("EmergencyContact not between", value1, value2, "EmergencyContact");
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

        public Criteria andCreatedAtEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("CreatedAt = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("CreatedAt <>", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("CreatedAt <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("CreatedAt >", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("CreatedAt > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("CreatedAt >=", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("CreatedAt >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("CreatedAt <", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("CreatedAt < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("CreatedAt <=", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualToColumn(Patients.Column column) {
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

        public Criteria andId_card_numberIsNull() {
            addCriterion("id_card_number is null");
            return (Criteria) this;
        }

        public Criteria andId_card_numberIsNotNull() {
            addCriterion("id_card_number is not null");
            return (Criteria) this;
        }

        public Criteria andId_card_numberEqualTo(String value) {
            addCriterion("id_card_number =", value, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_number = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_numberNotEqualTo(String value) {
            addCriterion("id_card_number <>", value, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_number <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_numberGreaterThan(String value) {
            addCriterion("id_card_number >", value, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_number > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_numberGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_number >=", value, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_number >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_numberLessThan(String value) {
            addCriterion("id_card_number <", value, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_number < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_numberLessThanOrEqualTo(String value) {
            addCriterion("id_card_number <=", value, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberLessThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_number <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_numberLike(String value) {
            addCriterion("id_card_number like", value, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberNotLike(String value) {
            addCriterion("id_card_number not like", value, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberIn(List<String> values) {
            addCriterion("id_card_number in", values, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberNotIn(List<String> values) {
            addCriterion("id_card_number not in", values, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberBetween(String value1, String value2) {
            addCriterion("id_card_number between", value1, value2, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_numberNotBetween(String value1, String value2) {
            addCriterion("id_card_number not between", value1, value2, "id_card_number");
            return (Criteria) this;
        }

        public Criteria andId_card_typeIsNull() {
            addCriterion("id_card_type is null");
            return (Criteria) this;
        }

        public Criteria andId_card_typeIsNotNull() {
            addCriterion("id_card_type is not null");
            return (Criteria) this;
        }

        public Criteria andId_card_typeEqualTo(String value) {
            addCriterion("id_card_type =", value, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_type = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_typeNotEqualTo(String value) {
            addCriterion("id_card_type <>", value, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_type <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_typeGreaterThan(String value) {
            addCriterion("id_card_type >", value, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_type > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_typeGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_type >=", value, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_type >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_typeLessThan(String value) {
            addCriterion("id_card_type <", value, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_type < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_typeLessThanOrEqualTo(String value) {
            addCriterion("id_card_type <=", value, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeLessThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_type <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_typeLike(String value) {
            addCriterion("id_card_type like", value, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeNotLike(String value) {
            addCriterion("id_card_type not like", value, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeIn(List<String> values) {
            addCriterion("id_card_type in", values, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeNotIn(List<String> values) {
            addCriterion("id_card_type not in", values, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeBetween(String value1, String value2) {
            addCriterion("id_card_type between", value1, value2, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_typeNotBetween(String value1, String value2) {
            addCriterion("id_card_type not between", value1, value2, "id_card_type");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryIsNull() {
            addCriterion("id_card_expiry is null");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryIsNotNull() {
            addCriterion("id_card_expiry is not null");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryEqualTo(Date value) {
            addCriterionForJDBCDate("id_card_expiry =", value, "id_card_expiry");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_expiry = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_expiryNotEqualTo(Date value) {
            addCriterionForJDBCDate("id_card_expiry <>", value, "id_card_expiry");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryNotEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_expiry <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_expiryGreaterThan(Date value) {
            addCriterionForJDBCDate("id_card_expiry >", value, "id_card_expiry");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryGreaterThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_expiry > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_expiryGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("id_card_expiry >=", value, "id_card_expiry");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryGreaterThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_expiry >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_expiryLessThan(Date value) {
            addCriterionForJDBCDate("id_card_expiry <", value, "id_card_expiry");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryLessThanColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_expiry < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_expiryLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("id_card_expiry <=", value, "id_card_expiry");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryLessThanOrEqualToColumn(Patients.Column column) {
            addCriterion(new StringBuilder("id_card_expiry <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andId_card_expiryIn(List<Date> values) {
            addCriterionForJDBCDate("id_card_expiry in", values, "id_card_expiry");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryNotIn(List<Date> values) {
            addCriterionForJDBCDate("id_card_expiry not in", values, "id_card_expiry");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("id_card_expiry between", value1, value2, "id_card_expiry");
            return (Criteria) this;
        }

        public Criteria andId_card_expiryNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("id_card_expiry not between", value1, value2, "id_card_expiry");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private PatientsExample example;

        protected Criteria(PatientsExample example) {
            super();
            this.example = example;
        }

        public PatientsExample example() {
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
        void example(PatientsExample example);
    }
}