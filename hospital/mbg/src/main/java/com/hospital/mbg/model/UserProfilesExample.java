package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserProfilesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserProfilesExample() {
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

    public UserProfilesExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public UserProfilesExample orderBy(String ... orderByClauses) {
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
        UserProfilesExample example = new UserProfilesExample();
        return example.createCriteria();
    }

    public UserProfilesExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public UserProfilesExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public UserProfilesExample distinct(boolean distinct) {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("user_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("user_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("user_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("user_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("user_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("user_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andFirst_nameIsNull() {
            addCriterion("first_name is null");
            return (Criteria) this;
        }

        public Criteria andFirst_nameIsNotNull() {
            addCriterion("first_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirst_nameEqualTo(String value) {
            addCriterion("first_name =", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("first_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFirst_nameNotEqualTo(String value) {
            addCriterion("first_name <>", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("first_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFirst_nameGreaterThan(String value) {
            addCriterion("first_name >", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("first_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFirst_nameGreaterThanOrEqualTo(String value) {
            addCriterion("first_name >=", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("first_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFirst_nameLessThan(String value) {
            addCriterion("first_name <", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("first_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFirst_nameLessThanOrEqualTo(String value) {
            addCriterion("first_name <=", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("first_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andFirst_nameLike(String value) {
            addCriterion("first_name like", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameNotLike(String value) {
            addCriterion("first_name not like", value, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameIn(List<String> values) {
            addCriterion("first_name in", values, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameNotIn(List<String> values) {
            addCriterion("first_name not in", values, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameBetween(String value1, String value2) {
            addCriterion("first_name between", value1, value2, "first_name");
            return (Criteria) this;
        }

        public Criteria andFirst_nameNotBetween(String value1, String value2) {
            addCriterion("first_name not between", value1, value2, "first_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameIsNull() {
            addCriterion("last_name is null");
            return (Criteria) this;
        }

        public Criteria andLast_nameIsNotNull() {
            addCriterion("last_name is not null");
            return (Criteria) this;
        }

        public Criteria andLast_nameEqualTo(String value) {
            addCriterion("last_name =", value, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("last_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLast_nameNotEqualTo(String value) {
            addCriterion("last_name <>", value, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("last_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLast_nameGreaterThan(String value) {
            addCriterion("last_name >", value, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("last_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLast_nameGreaterThanOrEqualTo(String value) {
            addCriterion("last_name >=", value, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("last_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLast_nameLessThan(String value) {
            addCriterion("last_name <", value, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("last_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLast_nameLessThanOrEqualTo(String value) {
            addCriterion("last_name <=", value, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("last_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLast_nameLike(String value) {
            addCriterion("last_name like", value, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameNotLike(String value) {
            addCriterion("last_name not like", value, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameIn(List<String> values) {
            addCriterion("last_name in", values, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameNotIn(List<String> values) {
            addCriterion("last_name not in", values, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameBetween(String value1, String value2) {
            addCriterion("last_name between", value1, value2, "last_name");
            return (Criteria) this;
        }

        public Criteria andLast_nameNotBetween(String value1, String value2) {
            addCriterion("last_name not between", value1, value2, "last_name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("gender = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("gender <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("gender > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("gender >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("gender < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("gender <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthIsNull() {
            addCriterion("date_of_birth is null");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthIsNotNull() {
            addCriterion("date_of_birth is not null");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthEqualTo(Date value) {
            addCriterionForJDBCDate("date_of_birth =", value, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("date_of_birth = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDate_of_birthNotEqualTo(Date value) {
            addCriterionForJDBCDate("date_of_birth <>", value, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("date_of_birth <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDate_of_birthGreaterThan(Date value) {
            addCriterionForJDBCDate("date_of_birth >", value, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("date_of_birth > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDate_of_birthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date_of_birth >=", value, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("date_of_birth >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDate_of_birthLessThan(Date value) {
            addCriterionForJDBCDate("date_of_birth <", value, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("date_of_birth < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDate_of_birthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date_of_birth <=", value, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("date_of_birth <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDate_of_birthIn(List<Date> values) {
            addCriterionForJDBCDate("date_of_birth in", values, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthNotIn(List<Date> values) {
            addCriterionForJDBCDate("date_of_birth not in", values, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date_of_birth between", value1, value2, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andDate_of_birthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date_of_birth not between", value1, value2, "date_of_birth");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureIsNull() {
            addCriterion("profile_picture is null");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureIsNotNull() {
            addCriterion("profile_picture is not null");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureEqualTo(String value) {
            addCriterion("profile_picture =", value, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("profile_picture = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProfile_pictureNotEqualTo(String value) {
            addCriterion("profile_picture <>", value, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("profile_picture <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProfile_pictureGreaterThan(String value) {
            addCriterion("profile_picture >", value, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("profile_picture > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProfile_pictureGreaterThanOrEqualTo(String value) {
            addCriterion("profile_picture >=", value, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("profile_picture >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProfile_pictureLessThan(String value) {
            addCriterion("profile_picture <", value, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("profile_picture < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProfile_pictureLessThanOrEqualTo(String value) {
            addCriterion("profile_picture <=", value, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("profile_picture <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProfile_pictureLike(String value) {
            addCriterion("profile_picture like", value, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureNotLike(String value) {
            addCriterion("profile_picture not like", value, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureIn(List<String> values) {
            addCriterion("profile_picture in", values, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureNotIn(List<String> values) {
            addCriterion("profile_picture not in", values, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureBetween(String value1, String value2) {
            addCriterion("profile_picture between", value1, value2, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andProfile_pictureNotBetween(String value1, String value2) {
            addCriterion("profile_picture not between", value1, value2, "profile_picture");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("address = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("address <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("address > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("address >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("address < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("address <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("city = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("city <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("city > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("city >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("city < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("city <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("state = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("state <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("state > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("state >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("state < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("state <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPostal_codeIsNull() {
            addCriterion("postal_code is null");
            return (Criteria) this;
        }

        public Criteria andPostal_codeIsNotNull() {
            addCriterion("postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostal_codeEqualTo(String value) {
            addCriterion("postal_code =", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("postal_code = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPostal_codeNotEqualTo(String value) {
            addCriterion("postal_code <>", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("postal_code <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPostal_codeGreaterThan(String value) {
            addCriterion("postal_code >", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("postal_code > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPostal_codeGreaterThanOrEqualTo(String value) {
            addCriterion("postal_code >=", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("postal_code >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPostal_codeLessThan(String value) {
            addCriterion("postal_code <", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("postal_code < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPostal_codeLessThanOrEqualTo(String value) {
            addCriterion("postal_code <=", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("postal_code <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPostal_codeLike(String value) {
            addCriterion("postal_code like", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeNotLike(String value) {
            addCriterion("postal_code not like", value, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeIn(List<String> values) {
            addCriterion("postal_code in", values, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeNotIn(List<String> values) {
            addCriterion("postal_code not in", values, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeBetween(String value1, String value2) {
            addCriterion("postal_code between", value1, value2, "postal_code");
            return (Criteria) this;
        }

        public Criteria andPostal_codeNotBetween(String value1, String value2) {
            addCriterion("postal_code not between", value1, value2, "postal_code");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("country = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("country <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("country > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("country >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("country < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("country <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
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

        public Criteria andCreated_atEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("created_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("created_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThan(Date value) {
            addCriterion("created_at >", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("created_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("created_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThan(Date value) {
            addCriterion("created_at <", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("created_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThanOrEqualToColumn(UserProfiles.Column column) {
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

        public Criteria andUpdated_atEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("updated_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("updated_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("updated_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThanOrEqualToColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("updated_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThan(Date value) {
            addCriterion("updated_at <", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThanColumn(UserProfiles.Column column) {
            addCriterion(new StringBuilder("updated_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThanOrEqualToColumn(UserProfiles.Column column) {
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
        private UserProfilesExample example;

        protected Criteria(UserProfilesExample example) {
            super();
            this.example = example;
        }

        public UserProfilesExample example() {
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
        void example(UserProfilesExample example);
    }
}