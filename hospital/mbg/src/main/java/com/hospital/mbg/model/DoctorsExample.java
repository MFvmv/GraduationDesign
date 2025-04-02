package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoctorsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorsExample() {
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

    public DoctorsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public DoctorsExample orderBy(String ... orderByClauses) {
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
        DoctorsExample example = new DoctorsExample();
        return example.createCriteria();
    }

    public DoctorsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public DoctorsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public DoctorsExample distinct(boolean distinct) {
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

        public Criteria andDoctorIDEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("DoctorID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDNotEqualTo(Integer value) {
            addCriterion("DoctorID <>", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDNotEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("DoctorID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDGreaterThan(Integer value) {
            addCriterion("DoctorID >", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDGreaterThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("DoctorID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("DoctorID >=", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDGreaterThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("DoctorID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDLessThan(Integer value) {
            addCriterion("DoctorID <", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDLessThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("DoctorID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDoctorIDLessThanOrEqualTo(Integer value) {
            addCriterion("DoctorID <=", value, "DoctorID");
            return (Criteria) this;
        }

        public Criteria andDoctorIDLessThanOrEqualToColumn(Doctors.Column column) {
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

        public Criteria andNameEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "Name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualToColumn(Doctors.Column column) {
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

        public Criteria andGenderEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Gender = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("Gender <>", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Gender <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("Gender >", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Gender > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("Gender >=", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Gender >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("Gender <", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Gender < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("Gender <=", value, "Gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualToColumn(Doctors.Column column) {
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

        public Criteria andPhoneIsNull() {
            addCriterion("Phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("Phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("Phone =", value, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Phone = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("Phone <>", value, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Phone <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("Phone >", value, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Phone > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Phone >=", value, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Phone >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("Phone <", value, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Phone < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("Phone <=", value, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Phone <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("Phone like", value, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("Phone not like", value, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("Phone in", values, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("Phone not in", values, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("Phone between", value1, value2, "Phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("Phone not between", value1, value2, "Phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Email = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Email <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Email > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Email >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Email < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Email <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "Email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "Email");
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

        public Criteria andDepartmentEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Department = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("Department <>", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Department <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("Department >", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Department > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("Department >=", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Department >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("Department <", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Department < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("Department <=", value, "Department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualToColumn(Doctors.Column column) {
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

        public Criteria andSpecializationIsNull() {
            addCriterion("Specialization is null");
            return (Criteria) this;
        }

        public Criteria andSpecializationIsNotNull() {
            addCriterion("Specialization is not null");
            return (Criteria) this;
        }

        public Criteria andSpecializationEqualTo(String value) {
            addCriterion("Specialization =", value, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Specialization = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSpecializationNotEqualTo(String value) {
            addCriterion("Specialization <>", value, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationNotEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Specialization <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSpecializationGreaterThan(String value) {
            addCriterion("Specialization >", value, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationGreaterThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Specialization > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSpecializationGreaterThanOrEqualTo(String value) {
            addCriterion("Specialization >=", value, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationGreaterThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Specialization >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSpecializationLessThan(String value) {
            addCriterion("Specialization <", value, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationLessThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Specialization < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSpecializationLessThanOrEqualTo(String value) {
            addCriterion("Specialization <=", value, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationLessThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("Specialization <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSpecializationLike(String value) {
            addCriterion("Specialization like", value, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationNotLike(String value) {
            addCriterion("Specialization not like", value, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationIn(List<String> values) {
            addCriterion("Specialization in", values, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationNotIn(List<String> values) {
            addCriterion("Specialization not in", values, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationBetween(String value1, String value2) {
            addCriterion("Specialization between", value1, value2, "Specialization");
            return (Criteria) this;
        }

        public Criteria andSpecializationNotBetween(String value1, String value2) {
            addCriterion("Specialization not between", value1, value2, "Specialization");
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

        public Criteria andCreatedAtEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("CreatedAt = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("CreatedAt <>", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("CreatedAt <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("CreatedAt >", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("CreatedAt > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("CreatedAt >=", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualToColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("CreatedAt >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("CreatedAt <", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanColumn(Doctors.Column column) {
            addCriterion(new StringBuilder("CreatedAt < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("CreatedAt <=", value, "CreatedAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualToColumn(Doctors.Column column) {
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
    }

    public static class Criteria extends GeneratedCriteria {
        private DoctorsExample example;

        protected Criteria(DoctorsExample example) {
            super();
            this.example = example;
        }

        public DoctorsExample example() {
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
        void example(DoctorsExample example);
    }
}