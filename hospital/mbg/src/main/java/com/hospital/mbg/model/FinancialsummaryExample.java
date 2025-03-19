package com.hospital.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinancialsummaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinancialsummaryExample() {
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

    public FinancialsummaryExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public FinancialsummaryExample orderBy(String ... orderByClauses) {
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
        FinancialsummaryExample example = new FinancialsummaryExample();
        return example.createCriteria();
    }

    public FinancialsummaryExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public FinancialsummaryExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public FinancialsummaryExample distinct(boolean distinct) {
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

        public Criteria and病人唯一标识IsNull() {
            addCriterion("病人唯一标识 is null");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识IsNotNull() {
            addCriterion("病人唯一标识 is not null");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识EqualTo(Integer value) {
            addCriterion("病人唯一标识 =", value, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识EqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("病人唯一标识 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and病人唯一标识NotEqualTo(Integer value) {
            addCriterion("病人唯一标识 <>", value, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识NotEqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("病人唯一标识 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and病人唯一标识GreaterThan(Integer value) {
            addCriterion("病人唯一标识 >", value, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识GreaterThanColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("病人唯一标识 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and病人唯一标识GreaterThanOrEqualTo(Integer value) {
            addCriterion("病人唯一标识 >=", value, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识GreaterThanOrEqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("病人唯一标识 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and病人唯一标识LessThan(Integer value) {
            addCriterion("病人唯一标识 <", value, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识LessThanColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("病人唯一标识 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and病人唯一标识LessThanOrEqualTo(Integer value) {
            addCriterion("病人唯一标识 <=", value, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识LessThanOrEqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("病人唯一标识 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and病人唯一标识In(List<Integer> values) {
            addCriterion("病人唯一标识 in", values, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识NotIn(List<Integer> values) {
            addCriterion("病人唯一标识 not in", values, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识Between(Integer value1, Integer value2) {
            addCriterion("病人唯一标识 between", value1, value2, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and病人唯一标识NotBetween(Integer value1, Integer value2) {
            addCriterion("病人唯一标识 not between", value1, value2, "病人唯一标识");
            return (Criteria) this;
        }

        public Criteria and支付总额IsNull() {
            addCriterion("支付总额 is null");
            return (Criteria) this;
        }

        public Criteria and支付总额IsNotNull() {
            addCriterion("支付总额 is not null");
            return (Criteria) this;
        }

        public Criteria and支付总额EqualTo(BigDecimal value) {
            addCriterion("支付总额 =", value, "支付总额");
            return (Criteria) this;
        }

        public Criteria and支付总额EqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("支付总额 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and支付总额NotEqualTo(BigDecimal value) {
            addCriterion("支付总额 <>", value, "支付总额");
            return (Criteria) this;
        }

        public Criteria and支付总额NotEqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("支付总额 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and支付总额GreaterThan(BigDecimal value) {
            addCriterion("支付总额 >", value, "支付总额");
            return (Criteria) this;
        }

        public Criteria and支付总额GreaterThanColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("支付总额 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and支付总额GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("支付总额 >=", value, "支付总额");
            return (Criteria) this;
        }

        public Criteria and支付总额GreaterThanOrEqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("支付总额 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and支付总额LessThan(BigDecimal value) {
            addCriterion("支付总额 <", value, "支付总额");
            return (Criteria) this;
        }

        public Criteria and支付总额LessThanColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("支付总额 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and支付总额LessThanOrEqualTo(BigDecimal value) {
            addCriterion("支付总额 <=", value, "支付总额");
            return (Criteria) this;
        }

        public Criteria and支付总额LessThanOrEqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("支付总额 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and支付总额In(List<BigDecimal> values) {
            addCriterion("支付总额 in", values, "支付总额");
            return (Criteria) this;
        }

        public Criteria and支付总额NotIn(List<BigDecimal> values) {
            addCriterion("支付总额 not in", values, "支付总额");
            return (Criteria) this;
        }

        public Criteria and支付总额Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("支付总额 between", value1, value2, "支付总额");
            return (Criteria) this;
        }

        public Criteria and支付总额NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("支付总额 not between", value1, value2, "支付总额");
            return (Criteria) this;
        }

        public Criteria and总交易次数IsNull() {
            addCriterion("总交易次数 is null");
            return (Criteria) this;
        }

        public Criteria and总交易次数IsNotNull() {
            addCriterion("总交易次数 is not null");
            return (Criteria) this;
        }

        public Criteria and总交易次数EqualTo(Long value) {
            addCriterion("总交易次数 =", value, "总交易次数");
            return (Criteria) this;
        }

        public Criteria and总交易次数EqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("总交易次数 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and总交易次数NotEqualTo(Long value) {
            addCriterion("总交易次数 <>", value, "总交易次数");
            return (Criteria) this;
        }

        public Criteria and总交易次数NotEqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("总交易次数 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and总交易次数GreaterThan(Long value) {
            addCriterion("总交易次数 >", value, "总交易次数");
            return (Criteria) this;
        }

        public Criteria and总交易次数GreaterThanColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("总交易次数 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and总交易次数GreaterThanOrEqualTo(Long value) {
            addCriterion("总交易次数 >=", value, "总交易次数");
            return (Criteria) this;
        }

        public Criteria and总交易次数GreaterThanOrEqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("总交易次数 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and总交易次数LessThan(Long value) {
            addCriterion("总交易次数 <", value, "总交易次数");
            return (Criteria) this;
        }

        public Criteria and总交易次数LessThanColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("总交易次数 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and总交易次数LessThanOrEqualTo(Long value) {
            addCriterion("总交易次数 <=", value, "总交易次数");
            return (Criteria) this;
        }

        public Criteria and总交易次数LessThanOrEqualToColumn(Financialsummary.Column column) {
            addCriterion(new StringBuilder("总交易次数 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria and总交易次数In(List<Long> values) {
            addCriterion("总交易次数 in", values, "总交易次数");
            return (Criteria) this;
        }

        public Criteria and总交易次数NotIn(List<Long> values) {
            addCriterion("总交易次数 not in", values, "总交易次数");
            return (Criteria) this;
        }

        public Criteria and总交易次数Between(Long value1, Long value2) {
            addCriterion("总交易次数 between", value1, value2, "总交易次数");
            return (Criteria) this;
        }

        public Criteria and总交易次数NotBetween(Long value1, Long value2) {
            addCriterion("总交易次数 not between", value1, value2, "总交易次数");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private FinancialsummaryExample example;

        protected Criteria(FinancialsummaryExample example) {
            super();
            this.example = example;
        }

        public FinancialsummaryExample example() {
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
        void example(FinancialsummaryExample example);
    }
}