package com.cbdz.sib.model;

import java.util.ArrayList;
import java.util.List;

public class MenuItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuItemExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemLabelIsNull() {
            addCriterion("item_label is null");
            return (Criteria) this;
        }

        public Criteria andItemLabelIsNotNull() {
            addCriterion("item_label is not null");
            return (Criteria) this;
        }

        public Criteria andItemLabelEqualTo(String value) {
            addCriterion("item_label =", value, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelNotEqualTo(String value) {
            addCriterion("item_label <>", value, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelGreaterThan(String value) {
            addCriterion("item_label >", value, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelGreaterThanOrEqualTo(String value) {
            addCriterion("item_label >=", value, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelLessThan(String value) {
            addCriterion("item_label <", value, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelLessThanOrEqualTo(String value) {
            addCriterion("item_label <=", value, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelLike(String value) {
            addCriterion("item_label like", value, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelNotLike(String value) {
            addCriterion("item_label not like", value, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelIn(List<String> values) {
            addCriterion("item_label in", values, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelNotIn(List<String> values) {
            addCriterion("item_label not in", values, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelBetween(String value1, String value2) {
            addCriterion("item_label between", value1, value2, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemLabelNotBetween(String value1, String value2) {
            addCriterion("item_label not between", value1, value2, "itemLabel");
            return (Criteria) this;
        }

        public Criteria andItemDispnoIsNull() {
            addCriterion("item_dispno is null");
            return (Criteria) this;
        }

        public Criteria andItemDispnoIsNotNull() {
            addCriterion("item_dispno is not null");
            return (Criteria) this;
        }

        public Criteria andItemDispnoEqualTo(Integer value) {
            addCriterion("item_dispno =", value, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemDispnoNotEqualTo(Integer value) {
            addCriterion("item_dispno <>", value, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemDispnoGreaterThan(Integer value) {
            addCriterion("item_dispno >", value, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemDispnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_dispno >=", value, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemDispnoLessThan(Integer value) {
            addCriterion("item_dispno <", value, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemDispnoLessThanOrEqualTo(Integer value) {
            addCriterion("item_dispno <=", value, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemDispnoIn(List<Integer> values) {
            addCriterion("item_dispno in", values, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemDispnoNotIn(List<Integer> values) {
            addCriterion("item_dispno not in", values, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemDispnoBetween(Integer value1, Integer value2) {
            addCriterion("item_dispno between", value1, value2, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemDispnoNotBetween(Integer value1, Integer value2) {
            addCriterion("item_dispno not between", value1, value2, "itemDispno");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("item_type like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("item_type not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderIsNull() {
            addCriterion("item_placeholder is null");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderIsNotNull() {
            addCriterion("item_placeholder is not null");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderEqualTo(String value) {
            addCriterion("item_placeholder =", value, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderNotEqualTo(String value) {
            addCriterion("item_placeholder <>", value, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderGreaterThan(String value) {
            addCriterion("item_placeholder >", value, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderGreaterThanOrEqualTo(String value) {
            addCriterion("item_placeholder >=", value, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderLessThan(String value) {
            addCriterion("item_placeholder <", value, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderLessThanOrEqualTo(String value) {
            addCriterion("item_placeholder <=", value, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderLike(String value) {
            addCriterion("item_placeholder like", value, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderNotLike(String value) {
            addCriterion("item_placeholder not like", value, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderIn(List<String> values) {
            addCriterion("item_placeholder in", values, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderNotIn(List<String> values) {
            addCriterion("item_placeholder not in", values, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderBetween(String value1, String value2) {
            addCriterion("item_placeholder between", value1, value2, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemPlaceholderNotBetween(String value1, String value2) {
            addCriterion("item_placeholder not between", value1, value2, "itemPlaceholder");
            return (Criteria) this;
        }

        public Criteria andItemSelTextIsNull() {
            addCriterion("item_sel_text is null");
            return (Criteria) this;
        }

        public Criteria andItemSelTextIsNotNull() {
            addCriterion("item_sel_text is not null");
            return (Criteria) this;
        }

        public Criteria andItemSelTextEqualTo(String value) {
            addCriterion("item_sel_text =", value, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextNotEqualTo(String value) {
            addCriterion("item_sel_text <>", value, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextGreaterThan(String value) {
            addCriterion("item_sel_text >", value, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextGreaterThanOrEqualTo(String value) {
            addCriterion("item_sel_text >=", value, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextLessThan(String value) {
            addCriterion("item_sel_text <", value, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextLessThanOrEqualTo(String value) {
            addCriterion("item_sel_text <=", value, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextLike(String value) {
            addCriterion("item_sel_text like", value, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextNotLike(String value) {
            addCriterion("item_sel_text not like", value, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextIn(List<String> values) {
            addCriterion("item_sel_text in", values, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextNotIn(List<String> values) {
            addCriterion("item_sel_text not in", values, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextBetween(String value1, String value2) {
            addCriterion("item_sel_text between", value1, value2, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andItemSelTextNotBetween(String value1, String value2) {
            addCriterion("item_sel_text not between", value1, value2, "itemSelText");
            return (Criteria) this;
        }

        public Criteria andMustFlagIsNull() {
            addCriterion("must_flag is null");
            return (Criteria) this;
        }

        public Criteria andMustFlagIsNotNull() {
            addCriterion("must_flag is not null");
            return (Criteria) this;
        }

        public Criteria andMustFlagEqualTo(String value) {
            addCriterion("must_flag =", value, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagNotEqualTo(String value) {
            addCriterion("must_flag <>", value, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagGreaterThan(String value) {
            addCriterion("must_flag >", value, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagGreaterThanOrEqualTo(String value) {
            addCriterion("must_flag >=", value, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagLessThan(String value) {
            addCriterion("must_flag <", value, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagLessThanOrEqualTo(String value) {
            addCriterion("must_flag <=", value, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagLike(String value) {
            addCriterion("must_flag like", value, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagNotLike(String value) {
            addCriterion("must_flag not like", value, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagIn(List<String> values) {
            addCriterion("must_flag in", values, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagNotIn(List<String> values) {
            addCriterion("must_flag not in", values, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagBetween(String value1, String value2) {
            addCriterion("must_flag between", value1, value2, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andMustFlagNotBetween(String value1, String value2) {
            addCriterion("must_flag not between", value1, value2, "mustFlag");
            return (Criteria) this;
        }

        public Criteria andItemInitvalIsNull() {
            addCriterion("item_initval is null");
            return (Criteria) this;
        }

        public Criteria andItemInitvalIsNotNull() {
            addCriterion("item_initval is not null");
            return (Criteria) this;
        }

        public Criteria andItemInitvalEqualTo(String value) {
            addCriterion("item_initval =", value, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalNotEqualTo(String value) {
            addCriterion("item_initval <>", value, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalGreaterThan(String value) {
            addCriterion("item_initval >", value, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalGreaterThanOrEqualTo(String value) {
            addCriterion("item_initval >=", value, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalLessThan(String value) {
            addCriterion("item_initval <", value, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalLessThanOrEqualTo(String value) {
            addCriterion("item_initval <=", value, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalLike(String value) {
            addCriterion("item_initval like", value, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalNotLike(String value) {
            addCriterion("item_initval not like", value, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalIn(List<String> values) {
            addCriterion("item_initval in", values, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalNotIn(List<String> values) {
            addCriterion("item_initval not in", values, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalBetween(String value1, String value2) {
            addCriterion("item_initval between", value1, value2, "itemInitval");
            return (Criteria) this;
        }

        public Criteria andItemInitvalNotBetween(String value1, String value2) {
            addCriterion("item_initval not between", value1, value2, "itemInitval");
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