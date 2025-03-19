package com.hospital.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrugconsumptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugconsumptionExample() {
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

    public DrugconsumptionExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public DrugconsumptionExample orderBy(String ... orderByClauses) {
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
        DrugconsumptionExample example = new DrugconsumptionExample();
        return example.createCriteria();
    }

    public DrugconsumptionExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public DrugconsumptionExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public DrugconsumptionExample distinct(boolean distinct) {
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

        public Criteria andConsumptionIDEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("ConsumptionID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDNotEqualTo(Integer value) {
            addCriterion("ConsumptionID <>", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDNotEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("ConsumptionID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDGreaterThan(Integer value) {
            addCriterion("ConsumptionID >", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDGreaterThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("ConsumptionID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ConsumptionID >=", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDGreaterThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("ConsumptionID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDLessThan(Integer value) {
            addCriterion("ConsumptionID <", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDLessThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("ConsumptionID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andConsumptionIDLessThanOrEqualTo(Integer value) {
            addCriterion("ConsumptionID <=", value, "ConsumptionID");
            return (Criteria) this;
        }

        public Criteria andConsumptionIDLessThanOrEqualToColumn(Drugconsumption.Column column) {
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

        public Criteria andDrugIDIsNull() {
            addCriterion("DrugID is null");
            return (Criteria) this;
        }

        public Criteria andDrugIDIsNotNull() {
            addCriterion("DrugID is not null");
            return (Criteria) this;
        }

        public Criteria andDrugIDEqualTo(Integer value) {
            addCriterion("DrugID =", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("DrugID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDNotEqualTo(Integer value) {
            addCriterion("DrugID <>", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDNotEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("DrugID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDGreaterThan(Integer value) {
            addCriterion("DrugID >", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDGreaterThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("DrugID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("DrugID >=", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDGreaterThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("DrugID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDLessThan(Integer value) {
            addCriterion("DrugID <", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDLessThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("DrugID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDLessThanOrEqualTo(Integer value) {
            addCriterion("DrugID <=", value, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDLessThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("DrugID <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDrugIDIn(List<Integer> values) {
            addCriterion("DrugID in", values, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDNotIn(List<Integer> values) {
            addCriterion("DrugID not in", values, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDBetween(Integer value1, Integer value2) {
            addCriterion("DrugID between", value1, value2, "DrugID");
            return (Criteria) this;
        }

        public Criteria andDrugIDNotBetween(Integer value1, Integer value2) {
            addCriterion("DrugID not between", value1, value2, "DrugID");
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

        public Criteria andPatientIDEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("PatientID = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualTo(Integer value) {
            addCriterion("PatientID <>", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDNotEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("PatientID <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThan(Integer value) {
            addCriterion("PatientID >", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("PatientID > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("PatientID >=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDGreaterThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("PatientID >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThan(Integer value) {
            addCriterion("PatientID <", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("PatientID < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualTo(Integer value) {
            addCriterion("PatientID <=", value, "PatientID");
            return (Criteria) this;
        }

        public Criteria andPatientIDLessThanOrEqualToColumn(Drugconsumption.Column column) {
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

        public Criteria andQuantityUsedIsNull() {
            addCriterion("QuantityUsed is null");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedIsNotNull() {
            addCriterion("QuantityUsed is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedEqualTo(Integer value) {
            addCriterion("QuantityUsed =", value, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("QuantityUsed = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityUsedNotEqualTo(Integer value) {
            addCriterion("QuantityUsed <>", value, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedNotEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("QuantityUsed <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityUsedGreaterThan(Integer value) {
            addCriterion("QuantityUsed >", value, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedGreaterThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("QuantityUsed > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("QuantityUsed >=", value, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedGreaterThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("QuantityUsed >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityUsedLessThan(Integer value) {
            addCriterion("QuantityUsed <", value, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedLessThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("QuantityUsed < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityUsedLessThanOrEqualTo(Integer value) {
            addCriterion("QuantityUsed <=", value, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedLessThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("QuantityUsed <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andQuantityUsedIn(List<Integer> values) {
            addCriterion("QuantityUsed in", values, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedNotIn(List<Integer> values) {
            addCriterion("QuantityUsed not in", values, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedBetween(Integer value1, Integer value2) {
            addCriterion("QuantityUsed between", value1, value2, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andQuantityUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("QuantityUsed not between", value1, value2, "QuantityUsed");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNull() {
            addCriterion("LastUpdated is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNotNull() {
            addCriterion("LastUpdated is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedEqualTo(Date value) {
            addCriterion("LastUpdated =", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("LastUpdated = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualTo(Date value) {
            addCriterion("LastUpdated <>", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("LastUpdated <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThan(Date value) {
            addCriterion("LastUpdated >", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("LastUpdated > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("LastUpdated >=", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("LastUpdated >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThan(Date value) {
            addCriterion("LastUpdated <", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("LastUpdated < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("LastUpdated <=", value, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("LastUpdated <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIn(List<Date> values) {
            addCriterion("LastUpdated in", values, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotIn(List<Date> values) {
            addCriterion("LastUpdated not in", values, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedBetween(Date value1, Date value2) {
            addCriterion("LastUpdated between", value1, value2, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("LastUpdated not between", value1, value2, "LastUpdated");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("Count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("Count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("Count =", value, "Count");
            return (Criteria) this;
        }

        public Criteria andCountEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("Count = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("Count <>", value, "Count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("Count <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("Count >", value, "Count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("Count > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Count >=", value, "Count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("Count >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("Count <", value, "Count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("Count < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("Count <=", value, "Count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualToColumn(Drugconsumption.Column column) {
            addCriterion(new StringBuilder("Count <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("Count in", values, "Count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("Count not in", values, "Count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("Count between", value1, value2, "Count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("Count not between", value1, value2, "Count");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private DrugconsumptionExample example;

        protected Criteria(DrugconsumptionExample example) {
            super();
            this.example = example;
        }

        public DrugconsumptionExample example() {
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
        void example(DrugconsumptionExample example);
    }
}