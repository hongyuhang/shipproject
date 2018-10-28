package com.cbdz.sib.model;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andMCodeIsNull() {
            addCriterion("m_code is null");
            return (Criteria) this;
        }

        public Criteria andMCodeIsNotNull() {
            addCriterion("m_code is not null");
            return (Criteria) this;
        }

        public Criteria andMCodeEqualTo(String value) {
            addCriterion("m_code =", value, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeNotEqualTo(String value) {
            addCriterion("m_code <>", value, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeGreaterThan(String value) {
            addCriterion("m_code >", value, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeGreaterThanOrEqualTo(String value) {
            addCriterion("m_code >=", value, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeLessThan(String value) {
            addCriterion("m_code <", value, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeLessThanOrEqualTo(String value) {
            addCriterion("m_code <=", value, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeLike(String value) {
            addCriterion("m_code like", value, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeNotLike(String value) {
            addCriterion("m_code not like", value, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeIn(List<String> values) {
            addCriterion("m_code in", values, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeNotIn(List<String> values) {
            addCriterion("m_code not in", values, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeBetween(String value1, String value2) {
            addCriterion("m_code between", value1, value2, "mCode");
            return (Criteria) this;
        }

        public Criteria andMCodeNotBetween(String value1, String value2) {
            addCriterion("m_code not between", value1, value2, "mCode");
            return (Criteria) this;
        }

        public Criteria andMNameIsNull() {
            addCriterion("m_name is null");
            return (Criteria) this;
        }

        public Criteria andMNameIsNotNull() {
            addCriterion("m_name is not null");
            return (Criteria) this;
        }

        public Criteria andMNameEqualTo(String value) {
            addCriterion("m_name =", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotEqualTo(String value) {
            addCriterion("m_name <>", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameGreaterThan(String value) {
            addCriterion("m_name >", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameGreaterThanOrEqualTo(String value) {
            addCriterion("m_name >=", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameLessThan(String value) {
            addCriterion("m_name <", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameLessThanOrEqualTo(String value) {
            addCriterion("m_name <=", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameLike(String value) {
            addCriterion("m_name like", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotLike(String value) {
            addCriterion("m_name not like", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameIn(List<String> values) {
            addCriterion("m_name in", values, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotIn(List<String> values) {
            addCriterion("m_name not in", values, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameBetween(String value1, String value2) {
            addCriterion("m_name between", value1, value2, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotBetween(String value1, String value2) {
            addCriterion("m_name not between", value1, value2, "mName");
            return (Criteria) this;
        }

        public Criteria andMLevelIsNull() {
            addCriterion("m_level is null");
            return (Criteria) this;
        }

        public Criteria andMLevelIsNotNull() {
            addCriterion("m_level is not null");
            return (Criteria) this;
        }

        public Criteria andMLevelEqualTo(Integer value) {
            addCriterion("m_level =", value, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMLevelNotEqualTo(Integer value) {
            addCriterion("m_level <>", value, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMLevelGreaterThan(Integer value) {
            addCriterion("m_level >", value, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_level >=", value, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMLevelLessThan(Integer value) {
            addCriterion("m_level <", value, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMLevelLessThanOrEqualTo(Integer value) {
            addCriterion("m_level <=", value, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMLevelIn(List<Integer> values) {
            addCriterion("m_level in", values, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMLevelNotIn(List<Integer> values) {
            addCriterion("m_level not in", values, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMLevelBetween(Integer value1, Integer value2) {
            addCriterion("m_level between", value1, value2, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("m_level not between", value1, value2, "mLevel");
            return (Criteria) this;
        }

        public Criteria andMDispnoIsNull() {
            addCriterion("m_dispno is null");
            return (Criteria) this;
        }

        public Criteria andMDispnoIsNotNull() {
            addCriterion("m_dispno is not null");
            return (Criteria) this;
        }

        public Criteria andMDispnoEqualTo(Integer value) {
            addCriterion("m_dispno =", value, "mDispno");
            return (Criteria) this;
        }

        public Criteria andMDispnoNotEqualTo(Integer value) {
            addCriterion("m_dispno <>", value, "mDispno");
            return (Criteria) this;
        }

        public Criteria andMDispnoGreaterThan(Integer value) {
            addCriterion("m_dispno >", value, "mDispno");
            return (Criteria) this;
        }

        public Criteria andMDispnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_dispno >=", value, "mDispno");
            return (Criteria) this;
        }

        public Criteria andMDispnoLessThan(Integer value) {
            addCriterion("m_dispno <", value, "mDispno");
            return (Criteria) this;
        }

        public Criteria andMDispnoLessThanOrEqualTo(Integer value) {
            addCriterion("m_dispno <=", value, "mDispno");
            return (Criteria) this;
        }

        public Criteria andMDispnoIn(List<Integer> values) {
            addCriterion("m_dispno in", values, "mDispno");
            return (Criteria) this;
        }

        public Criteria andMDispnoNotIn(List<Integer> values) {
            addCriterion("m_dispno not in", values, "mDispno");
            return (Criteria) this;
        }

        public Criteria andMDispnoBetween(Integer value1, Integer value2) {
            addCriterion("m_dispno between", value1, value2, "mDispno");
            return (Criteria) this;
        }

        public Criteria andMDispnoNotBetween(Integer value1, Integer value2) {
            addCriterion("m_dispno not between", value1, value2, "mDispno");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
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
}