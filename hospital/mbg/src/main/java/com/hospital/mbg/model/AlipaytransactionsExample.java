package com.hospital.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AlipaytransactionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlipaytransactionsExample() {
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

    public AlipaytransactionsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public AlipaytransactionsExample orderBy(String ... orderByClauses) {
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
        AlipaytransactionsExample example = new AlipaytransactionsExample();
        return example.createCriteria();
    }

    public AlipaytransactionsExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public AlipaytransactionsExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public AlipaytransactionsExample distinct(boolean distinct) {
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

        public Criteria andAlipayTransactionIDIsNull() {
            addCriterion("AlipayTransactionID is null");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDIsNotNull() {
            addCriterion("AlipayTransactionID is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDEqualTo(Integer value) {
            addCriterion("AlipayTransactionID =", value, "AlipayTransactionID");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("AlipayTransactionID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDNotEqualTo(Integer value) {
            addCriterion("AlipayTransactionID <>", value, "AlipayTransactionID");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDNotEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("AlipayTransactionID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDGreaterThan(Integer value) {
            addCriterion("AlipayTransactionID >", value, "AlipayTransactionID");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDGreaterThanColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("AlipayTransactionID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("AlipayTransactionID >=", value, "AlipayTransactionID");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDGreaterThanOrEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("AlipayTransactionID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDLessThan(Integer value) {
            addCriterion("AlipayTransactionID <", value, "AlipayTransactionID");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDLessThanColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("AlipayTransactionID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDLessThanOrEqualTo(Integer value) {
            addCriterion("AlipayTransactionID <=", value, "AlipayTransactionID");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDLessThanOrEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("AlipayTransactionID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDIn(List<Integer> values) {
            addCriterion("AlipayTransactionID in", values, "AlipayTransactionID");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDNotIn(List<Integer> values) {
            addCriterion("AlipayTransactionID not in", values, "AlipayTransactionID");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDBetween(Integer value1, Integer value2) {
            addCriterion("AlipayTransactionID between", value1, value2, "AlipayTransactionID");
            return (Criteria) this;
        }

        public Criteria andAlipayTransactionIDNotBetween(Integer value1, Integer value2) {
            addCriterion("AlipayTransactionID not between", value1, value2, "AlipayTransactionID");
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

        public Criteria andOrderNumberEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("OrderNumber = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("OrderNumber <>", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("OrderNumber <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("OrderNumber >", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("OrderNumber > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("OrderNumber >=", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("OrderNumber >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("OrderNumber <", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("OrderNumber < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("OrderNumber <=", value, "OrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualToColumn(Alipaytransactions.Column column) {
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

        public Criteria andTotalAmountIsNull() {
            addCriterion("TotalAmount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("TotalAmount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("TotalAmount =", value, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TotalAmount = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("TotalAmount <>", value, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TotalAmount <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("TotalAmount >", value, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TotalAmount > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TotalAmount >=", value, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TotalAmount >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("TotalAmount <", value, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TotalAmount < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TotalAmount <=", value, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TotalAmount <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("TotalAmount in", values, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("TotalAmount not in", values, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TotalAmount between", value1, value2, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TotalAmount not between", value1, value2, "TotalAmount");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNull() {
            addCriterion("TradeStatus is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("TradeStatus is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(String value) {
            addCriterion("TradeStatus =", value, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TradeStatus = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(String value) {
            addCriterion("TradeStatus <>", value, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TradeStatus <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(String value) {
            addCriterion("TradeStatus >", value, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TradeStatus > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("TradeStatus >=", value, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TradeStatus >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(String value) {
            addCriterion("TradeStatus <", value, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TradeStatus < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("TradeStatus <=", value, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualToColumn(Alipaytransactions.Column column) {
            addCriterion(new StringBuilder("TradeStatus <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTradeStatusLike(String value) {
            addCriterion("TradeStatus like", value, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotLike(String value) {
            addCriterion("TradeStatus not like", value, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<String> values) {
            addCriterion("TradeStatus in", values, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<String> values) {
            addCriterion("TradeStatus not in", values, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(String value1, String value2) {
            addCriterion("TradeStatus between", value1, value2, "TradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(String value1, String value2) {
            addCriterion("TradeStatus not between", value1, value2, "TradeStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private AlipaytransactionsExample example;

        protected Criteria(AlipaytransactionsExample example) {
            super();
            this.example = example;
        }

        public AlipaytransactionsExample example() {
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
        void example(AlipaytransactionsExample example);
    }
}