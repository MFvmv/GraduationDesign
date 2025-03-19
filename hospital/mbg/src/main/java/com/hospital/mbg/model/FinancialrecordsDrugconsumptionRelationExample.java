package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class FinancialrecordsDrugconsumptionRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinancialrecordsDrugconsumptionRelationExample() {
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

    public FinancialrecordsDrugconsumptionRelationExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public FinancialrecordsDrugconsumptionRelationExample orderBy(String ... orderByClauses) {
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
        FinancialrecordsDrugconsumptionRelationExample example = new FinancialrecordsDrugconsumptionRelationExample();
        return example.createCriteria();
    }

    public FinancialrecordsDrugconsumptionRelationExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public FinancialrecordsDrugconsumptionRelationExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public FinancialrecordsDrugconsumptionRelationExample distinct(boolean distinct) {
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

        public Criteria andConsumptionIDIsNull() {
            addCriterion("ConsumptionID is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDIsNotNull() {
            addCriterion("ConsumptionID is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDEqualTo(Integer value) {
            addCriterion("ConsumptionID =", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDEqualToColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("ConsumptionID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDNotEqualTo(Integer value) {
            addCriterion("ConsumptionID <>", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDNotEqualToColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("ConsumptionID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDGreaterThan(Integer value) {
            addCriterion("ConsumptionID >", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDGreaterThanColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("ConsumptionID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ConsumptionID >=", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDGreaterThanOrEqualToColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("ConsumptionID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDLessThan(Integer value) {
            addCriterion("ConsumptionID <", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDLessThanColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("ConsumptionID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDLessThanOrEqualTo(Integer value) {
            addCriterion("ConsumptionID <=", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDLessThanOrEqualToColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("ConsumptionID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDIn(List<Integer> values) {
            addCriterion("ConsumptionID in", values, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDNotIn(List<Integer> values) {
            addCriterion("ConsumptionID not in", values, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDBetween(Integer value1, Integer value2) {
            addCriterion("ConsumptionID between", value1, value2, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ConsumptionID not between", value1, value2, "ConsumptionID");
            return (Criteria) this;
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

        public Criteria andTransactionIDEqualToColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotEqualTo(Integer value) {
            addCriterion("TransactionID <>", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotEqualToColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThan(Integer value) {
            addCriterion("TransactionID >", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("TransactionID >=", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanOrEqualToColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThan(Integer value) {
            addCriterion("TransactionID <", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanOrEqualTo(Integer value) {
            addCriterion("TransactionID <=", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanOrEqualToColumn(FinancialrecordsDrugconsumptionRelation.Column column) {
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
    }

    public static class Criteria extends GeneratedCriteria {
        private FinancialrecordsDrugconsumptionRelationExample example;

        protected Criteria(FinancialrecordsDrugconsumptionRelationExample example) {
            super();
            this.example = example;
        }

        public FinancialrecordsDrugconsumptionRelationExample example() {
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
        void example(FinancialrecordsDrugconsumptionRelationExample example);
    }
}