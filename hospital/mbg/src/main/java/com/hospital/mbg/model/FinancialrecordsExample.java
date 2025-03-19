package com.hospital.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FinancialrecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinancialrecordsExample() {
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

    public FinancialrecordsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public FinancialrecordsExample orderBy(String ... orderByClauses) {
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
        FinancialrecordsExample example = new FinancialrecordsExample();
        return example.createCriteria();
    }

    public FinancialrecordsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public FinancialrecordsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public FinancialrecordsExample distinct(boolean distinct) {
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

        public Criteria andTransactionIDIsNull() {
            addCriterion("TransactionID is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIDIsNotNull() {
            addCriterion("TransactionID is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIDEqualTo(Integer value) {
            addCriterion("TransactionID =", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotEqualTo(Integer value) {
            addCriterion("TransactionID <>", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThan(Integer value) {
            addCriterion("TransactionID >", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("TransactionID >=", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThan(Integer value) {
            addCriterion("TransactionID <", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanOrEqualTo(Integer value) {
            addCriterion("TransactionID <=", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDIn(List<Integer> values) {
            addCriterion("TransactionID in", values, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotIn(List<Integer> values) {
            addCriterion("TransactionID not in", values, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDBetween(Integer value1, Integer value2) {
            addCriterion("TransactionID between", value1, value2, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotBetween(Integer value1, Integer value2) {
            addCriterion("TransactionID not between", value1, value2, "TransactionID");
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

        public Criteria andPatientIDEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PatientID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualTo(Integer value) {
            addCriterion("PatientID <>", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PatientID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThan(Integer value) {
            addCriterion("PatientID >", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PatientID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("PatientID >=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PatientID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThan(Integer value) {
            addCriterion("PatientID <", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PatientID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualTo(Integer value) {
            addCriterion("PatientID <=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualToColumn(Financialrecords.Column column) {
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

        public Criteria andAmountIsNull() {
            addCriterion("Amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("Amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("Amount =", value, "Amount");
            return (Criteria) this;
        }

        public Criteria andAmountEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("Amount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("Amount <>", value, "Amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("Amount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("Amount >", value, "Amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("Amount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Amount >=", value, "Amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("Amount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("Amount <", value, "Amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("Amount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Amount <=", value, "Amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("Amount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("Amount in", values, "Amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("Amount not in", values, "Amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Amount between", value1, value2, "Amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Amount not between", value1, value2, "Amount");
            return (Criteria) this;
        }

        public Criteria andTransactionDateIsNull() {
            addCriterion("TransactionDate is null");
            return (Criteria) this;
        }

        public Criteria andTransactionDateIsNotNull() {
            addCriterion("TransactionDate is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionDateEqualTo(Date value) {
            addCriterionForJDBCDate("TransactionDate =", value, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionDate = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("TransactionDate <>", value, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionDate <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("TransactionDate >", value, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateGreaterThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionDate > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TransactionDate >=", value, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateGreaterThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionDate >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionDateLessThan(Date value) {
            addCriterionForJDBCDate("TransactionDate <", value, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateLessThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionDate < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TransactionDate <=", value, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateLessThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("TransactionDate <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionDateIn(List<Date> values) {
            addCriterionForJDBCDate("TransactionDate in", values, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("TransactionDate not in", values, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TransactionDate between", value1, value2, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TransactionDate not between", value1, value2, "TransactionDate");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("PaymentMethod is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("PaymentMethod is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(String value) {
            addCriterion("PaymentMethod =", value, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentMethod = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(String value) {
            addCriterion("PaymentMethod <>", value, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentMethod <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(String value) {
            addCriterion("PaymentMethod >", value, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentMethod > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("PaymentMethod >=", value, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentMethod >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(String value) {
            addCriterion("PaymentMethod <", value, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentMethod < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(String value) {
            addCriterion("PaymentMethod <=", value, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentMethod <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLike(String value) {
            addCriterion("PaymentMethod like", value, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotLike(String value) {
            addCriterion("PaymentMethod not like", value, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<String> values) {
            addCriterion("PaymentMethod in", values, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<String> values) {
            addCriterion("PaymentMethod not in", values, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(String value1, String value2) {
            addCriterion("PaymentMethod between", value1, value2, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(String value1, String value2) {
            addCriterion("PaymentMethod not between", value1, value2, "PaymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("PaymentStatus is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("PaymentStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(String value) {
            addCriterion("PaymentStatus =", value, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentStatus = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(String value) {
            addCriterion("PaymentStatus <>", value, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentStatus <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(String value) {
            addCriterion("PaymentStatus >", value, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentStatus > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PaymentStatus >=", value, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentStatus >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(String value) {
            addCriterion("PaymentStatus <", value, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentStatus < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(String value) {
            addCriterion("PaymentStatus <=", value, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("PaymentStatus <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLike(String value) {
            addCriterion("PaymentStatus like", value, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotLike(String value) {
            addCriterion("PaymentStatus not like", value, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<String> values) {
            addCriterion("PaymentStatus in", values, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<String> values) {
            addCriterion("PaymentStatus not in", values, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(String value1, String value2) {
            addCriterion("PaymentStatus between", value1, value2, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(String value1, String value2) {
            addCriterion("PaymentStatus not between", value1, value2, "PaymentStatus");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("OrderNumber is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("OrderNumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("OrderNumber =", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("OrderNumber = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("OrderNumber <>", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("OrderNumber <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("OrderNumber >", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("OrderNumber > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("OrderNumber >=", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("OrderNumber >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("OrderNumber <", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("OrderNumber < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("OrderNumber <=", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualToColumn(Financialrecords.Column column) {
            addCriterion(new StringBuilder("OrderNumber <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("OrderNumber like", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("OrderNumber not like", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("OrderNumber in", values, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("OrderNumber not in", values, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("OrderNumber between", value1, value2, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("OrderNumber not between", value1, value2, "OrderNumber");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private FinancialrecordsExample example;

        protected Criteria(FinancialrecordsExample example) {
            super();
            this.example = example;
        }

        public FinancialrecordsExample example() {
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
        void example(FinancialrecordsExample example);
    }
}