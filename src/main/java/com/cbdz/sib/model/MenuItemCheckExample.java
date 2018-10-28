package com.cbdz.sib.model;

import java.util.ArrayList;
import java.util.List;

public class MenuItemCheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuItemCheckExample() {
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

        public Criteria andCheckNoIsNull() {
            addCriterion("check_no is null");
            return (Criteria) this;
        }

        public Criteria andCheckNoIsNotNull() {
            addCriterion("check_no is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNoEqualTo(Integer value) {
            addCriterion("check_no =", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoNotEqualTo(Integer value) {
            addCriterion("check_no <>", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoGreaterThan(Integer value) {
            addCriterion("check_no >", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_no >=", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoLessThan(Integer value) {
            addCriterion("check_no <", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoLessThanOrEqualTo(Integer value) {
            addCriterion("check_no <=", value, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoIn(List<Integer> values) {
            addCriterion("check_no in", values, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoNotIn(List<Integer> values) {
            addCriterion("check_no not in", values, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoBetween(Integer value1, Integer value2) {
            addCriterion("check_no between", value1, value2, "checkNo");
            return (Criteria) this;
        }

        public Criteria andCheckNoNotBetween(Integer value1, Integer value2) {
            addCriterion("check_no not between", value1, value2, "checkNo");
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

        public Criteria andCheckMethodIsNull() {
            addCriterion("check_method is null");
            return (Criteria) this;
        }

        public Criteria andCheckMethodIsNotNull() {
            addCriterion("check_method is not null");
            return (Criteria) this;
        }

        public Criteria andCheckMethodEqualTo(String value) {
            addCriterion("check_method =", value, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodNotEqualTo(String value) {
            addCriterion("check_method <>", value, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodGreaterThan(String value) {
            addCriterion("check_method >", value, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodGreaterThanOrEqualTo(String value) {
            addCriterion("check_method >=", value, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodLessThan(String value) {
            addCriterion("check_method <", value, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodLessThanOrEqualTo(String value) {
            addCriterion("check_method <=", value, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodLike(String value) {
            addCriterion("check_method like", value, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodNotLike(String value) {
            addCriterion("check_method not like", value, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodIn(List<String> values) {
            addCriterion("check_method in", values, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodNotIn(List<String> values) {
            addCriterion("check_method not in", values, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodBetween(String value1, String value2) {
            addCriterion("check_method between", value1, value2, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckMethodNotBetween(String value1, String value2) {
            addCriterion("check_method not between", value1, value2, "checkMethod");
            return (Criteria) this;
        }

        public Criteria andCheckParamIsNull() {
            addCriterion("check_param is null");
            return (Criteria) this;
        }

        public Criteria andCheckParamIsNotNull() {
            addCriterion("check_param is not null");
            return (Criteria) this;
        }

        public Criteria andCheckParamEqualTo(String value) {
            addCriterion("check_param =", value, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamNotEqualTo(String value) {
            addCriterion("check_param <>", value, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamGreaterThan(String value) {
            addCriterion("check_param >", value, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamGreaterThanOrEqualTo(String value) {
            addCriterion("check_param >=", value, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamLessThan(String value) {
            addCriterion("check_param <", value, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamLessThanOrEqualTo(String value) {
            addCriterion("check_param <=", value, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamLike(String value) {
            addCriterion("check_param like", value, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamNotLike(String value) {
            addCriterion("check_param not like", value, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamIn(List<String> values) {
            addCriterion("check_param in", values, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamNotIn(List<String> values) {
            addCriterion("check_param not in", values, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamBetween(String value1, String value2) {
            addCriterion("check_param between", value1, value2, "checkParam");
            return (Criteria) this;
        }

        public Criteria andCheckParamNotBetween(String value1, String value2) {
            addCriterion("check_param not between", value1, value2, "checkParam");
            return (Criteria) this;
        }

        public Criteria andErrMsgIsNull() {
            addCriterion("err_msg is null");
            return (Criteria) this;
        }

        public Criteria andErrMsgIsNotNull() {
            addCriterion("err_msg is not null");
            return (Criteria) this;
        }

        public Criteria andErrMsgEqualTo(String value) {
            addCriterion("err_msg =", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotEqualTo(String value) {
            addCriterion("err_msg <>", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgGreaterThan(String value) {
            addCriterion("err_msg >", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgGreaterThanOrEqualTo(String value) {
            addCriterion("err_msg >=", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLessThan(String value) {
            addCriterion("err_msg <", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLessThanOrEqualTo(String value) {
            addCriterion("err_msg <=", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLike(String value) {
            addCriterion("err_msg like", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotLike(String value) {
            addCriterion("err_msg not like", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgIn(List<String> values) {
            addCriterion("err_msg in", values, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotIn(List<String> values) {
            addCriterion("err_msg not in", values, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgBetween(String value1, String value2) {
            addCriterion("err_msg between", value1, value2, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotBetween(String value1, String value2) {
            addCriterion("err_msg not between", value1, value2, "errMsg");
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