package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class FinancialrecordsInpatientsRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinancialrecordsInpatientsRelationExample() {
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

    public FinancialrecordsInpatientsRelationExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public FinancialrecordsInpatientsRelationExample orderBy(String ... orderByClauses) {
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
        FinancialrecordsInpatientsRelationExample example = new FinancialrecordsInpatientsRelationExample();
        return example.createCriteria();
    }

    public FinancialrecordsInpatientsRelationExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public FinancialrecordsInpatientsRelationExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public FinancialrecordsInpatientsRelationExample distinct(boolean distinct) {
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

        public Criteria andInpatientIDEqualToColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("InpatientID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDNotEqualTo(Integer value) {
            addCriterion("InpatientID <>", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDNotEqualToColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("InpatientID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDGreaterThan(Integer value) {
            addCriterion("InpatientID >", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDGreaterThanColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("InpatientID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("InpatientID >=", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDGreaterThanOrEqualToColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("InpatientID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDLessThan(Integer value) {
            addCriterion("InpatientID <", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDLessThanColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("InpatientID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andInpatientIDLessThanOrEqualTo(Integer value) {
            addCriterion("InpatientID <=", value, "InpatientID");
            return (Criteria) this;
        }

        public Criteria andInpatientIDLessThanOrEqualToColumn(FinancialrecordsInpatientsRelation.Column column) {
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

        public Criteria andTransactionIDEqualToColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotEqualTo(Integer value) {
            addCriterion("TransactionID <>", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDNotEqualToColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThan(Integer value) {
            addCriterion("TransactionID >", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("TransactionID >=", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDGreaterThanOrEqualToColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThan(Integer value) {
            addCriterion("TransactionID <", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanColumn(FinancialrecordsInpatientsRelation.Column column) {
            addCriterion(new StringBuilder("TransactionID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanOrEqualTo(Integer value) {
            addCriterion("TransactionID <=", value, "TransactionID");
            return (Criteria) this;
        }

        public Criteria andTransactionIDLessThanOrEqualToColumn(FinancialrecordsInpatientsRelation.Column column) {
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
        private FinancialrecordsInpatientsRelationExample example;

        protected Criteria(FinancialrecordsInpatientsRelationExample example) {
            super();
            this.example = example;
        }

        public FinancialrecordsInpatientsRelationExample example() {
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
        void example(FinancialrecordsInpatientsRelationExample example);
    }
}