package com.cbdz.sib.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataSHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataSHistoryExample() {
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

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(Long value) {
            addCriterion("seq =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(Long value) {
            addCriterion("seq <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Long value) {
            addCriterion("seq >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Long value) {
            addCriterion("seq >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Long value) {
            addCriterion("seq <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Long value) {
            addCriterion("seq <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Long> values) {
            addCriterion("seq in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Long> values) {
            addCriterion("seq not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Long value1, Long value2) {
            addCriterion("seq between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Long value1, Long value2) {
            addCriterion("seq not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSTimeIsNull() {
            addCriterion("s_time is null");
            return (Criteria) this;
        }

        public Criteria andSTimeIsNotNull() {
            addCriterion("s_time is not null");
            return (Criteria) this;
        }

        public Criteria andSTimeEqualTo(Date value) {
            addCriterion("s_time =", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeNotEqualTo(Date value) {
            addCriterion("s_time <>", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeGreaterThan(Date value) {
            addCriterion("s_time >", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("s_time >=", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeLessThan(Date value) {
            addCriterion("s_time <", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeLessThanOrEqualTo(Date value) {
            addCriterion("s_time <=", value, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeIn(List<Date> values) {
            addCriterion("s_time in", values, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeNotIn(List<Date> values) {
            addCriterion("s_time not in", values, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeBetween(Date value1, Date value2) {
            addCriterion("s_time between", value1, value2, "sTime");
            return (Criteria) this;
        }

        public Criteria andSTimeNotBetween(Date value1, Date value2) {
            addCriterion("s_time not between", value1, value2, "sTime");
            return (Criteria) this;
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

        public Criteria andMsgCodeIsNull() {
            addCriterion("msg_code is null");
            return (Criteria) this;
        }

        public Criteria andMsgCodeIsNotNull() {
            addCriterion("msg_code is not null");
            return (Criteria) this;
        }

        public Criteria andMsgCodeEqualTo(String value) {
            addCriterion("msg_code =", value, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeNotEqualTo(String value) {
            addCriterion("msg_code <>", value, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeGreaterThan(String value) {
            addCriterion("msg_code >", value, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("msg_code >=", value, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeLessThan(String value) {
            addCriterion("msg_code <", value, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeLessThanOrEqualTo(String value) {
            addCriterion("msg_code <=", value, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeLike(String value) {
            addCriterion("msg_code like", value, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeNotLike(String value) {
            addCriterion("msg_code not like", value, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeIn(List<String> values) {
            addCriterion("msg_code in", values, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeNotIn(List<String> values) {
            addCriterion("msg_code not in", values, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeBetween(String value1, String value2) {
            addCriterion("msg_code between", value1, value2, "msgCode");
            return (Criteria) this;
        }

        public Criteria andMsgCodeNotBetween(String value1, String value2) {
            addCriterion("msg_code not between", value1, value2, "msgCode");
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

        public Criteria andSTypeIsNull() {
            addCriterion("s_type is null");
            return (Criteria) this;
        }

        public Criteria andSTypeIsNotNull() {
            addCriterion("s_type is not null");
            return (Criteria) this;
        }

        public Criteria andSTypeEqualTo(String value) {
            addCriterion("s_type =", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeNotEqualTo(String value) {
            addCriterion("s_type <>", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeGreaterThan(String value) {
            addCriterion("s_type >", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeGreaterThanOrEqualTo(String value) {
            addCriterion("s_type >=", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeLessThan(String value) {
            addCriterion("s_type <", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeLessThanOrEqualTo(String value) {
            addCriterion("s_type <=", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeLike(String value) {
            addCriterion("s_type like", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeNotLike(String value) {
            addCriterion("s_type not like", value, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeIn(List<String> values) {
            addCriterion("s_type in", values, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeNotIn(List<String> values) {
            addCriterion("s_type not in", values, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeBetween(String value1, String value2) {
            addCriterion("s_type between", value1, value2, "sType");
            return (Criteria) this;
        }

        public Criteria andSTypeNotBetween(String value1, String value2) {
            addCriterion("s_type not between", value1, value2, "sType");
            return (Criteria) this;
        }

        public Criteria andMmsiIsNull() {
            addCriterion("mmsi is null");
            return (Criteria) this;
        }

        public Criteria andMmsiIsNotNull() {
            addCriterion("mmsi is not null");
            return (Criteria) this;
        }

        public Criteria andMmsiEqualTo(String value) {
            addCriterion("mmsi =", value, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiNotEqualTo(String value) {
            addCriterion("mmsi <>", value, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiGreaterThan(String value) {
            addCriterion("mmsi >", value, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiGreaterThanOrEqualTo(String value) {
            addCriterion("mmsi >=", value, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiLessThan(String value) {
            addCriterion("mmsi <", value, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiLessThanOrEqualTo(String value) {
            addCriterion("mmsi <=", value, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiLike(String value) {
            addCriterion("mmsi like", value, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiNotLike(String value) {
            addCriterion("mmsi not like", value, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiIn(List<String> values) {
            addCriterion("mmsi in", values, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiNotIn(List<String> values) {
            addCriterion("mmsi not in", values, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiBetween(String value1, String value2) {
            addCriterion("mmsi between", value1, value2, "mmsi");
            return (Criteria) this;
        }

        public Criteria andMmsiNotBetween(String value1, String value2) {
            addCriterion("mmsi not between", value1, value2, "mmsi");
            return (Criteria) this;
        }

        public Criteria andRetCodeIsNull() {
            addCriterion("ret_code is null");
            return (Criteria) this;
        }

        public Criteria andRetCodeIsNotNull() {
            addCriterion("ret_code is not null");
            return (Criteria) this;
        }

        public Criteria andRetCodeEqualTo(String value) {
            addCriterion("ret_code =", value, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeNotEqualTo(String value) {
            addCriterion("ret_code <>", value, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeGreaterThan(String value) {
            addCriterion("ret_code >", value, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ret_code >=", value, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeLessThan(String value) {
            addCriterion("ret_code <", value, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeLessThanOrEqualTo(String value) {
            addCriterion("ret_code <=", value, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeLike(String value) {
            addCriterion("ret_code like", value, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeNotLike(String value) {
            addCriterion("ret_code not like", value, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeIn(List<String> values) {
            addCriterion("ret_code in", values, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeNotIn(List<String> values) {
            addCriterion("ret_code not in", values, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeBetween(String value1, String value2) {
            addCriterion("ret_code between", value1, value2, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetCodeNotBetween(String value1, String value2) {
            addCriterion("ret_code not between", value1, value2, "retCode");
            return (Criteria) this;
        }

        public Criteria andRetMsgIsNull() {
            addCriterion("ret_msg is null");
            return (Criteria) this;
        }

        public Criteria andRetMsgIsNotNull() {
            addCriterion("ret_msg is not null");
            return (Criteria) this;
        }

        public Criteria andRetMsgEqualTo(String value) {
            addCriterion("ret_msg =", value, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgNotEqualTo(String value) {
            addCriterion("ret_msg <>", value, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgGreaterThan(String value) {
            addCriterion("ret_msg >", value, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgGreaterThanOrEqualTo(String value) {
            addCriterion("ret_msg >=", value, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgLessThan(String value) {
            addCriterion("ret_msg <", value, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgLessThanOrEqualTo(String value) {
            addCriterion("ret_msg <=", value, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgLike(String value) {
            addCriterion("ret_msg like", value, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgNotLike(String value) {
            addCriterion("ret_msg not like", value, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgIn(List<String> values) {
            addCriterion("ret_msg in", values, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgNotIn(List<String> values) {
            addCriterion("ret_msg not in", values, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgBetween(String value1, String value2) {
            addCriterion("ret_msg between", value1, value2, "retMsg");
            return (Criteria) this;
        }

        public Criteria andRetMsgNotBetween(String value1, String value2) {
            addCriterion("ret_msg not between", value1, value2, "retMsg");
            return (Criteria) this;
        }

        public Criteria andPageJsonIsNull() {
            addCriterion("page_json is null");
            return (Criteria) this;
        }

        public Criteria andPageJsonIsNotNull() {
            addCriterion("page_json is not null");
            return (Criteria) this;
        }

        public Criteria andPageJsonEqualTo(String value) {
            addCriterion("page_json =", value, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonNotEqualTo(String value) {
            addCriterion("page_json <>", value, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonGreaterThan(String value) {
            addCriterion("page_json >", value, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonGreaterThanOrEqualTo(String value) {
            addCriterion("page_json >=", value, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonLessThan(String value) {
            addCriterion("page_json <", value, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonLessThanOrEqualTo(String value) {
            addCriterion("page_json <=", value, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonLike(String value) {
            addCriterion("page_json like", value, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonNotLike(String value) {
            addCriterion("page_json not like", value, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonIn(List<String> values) {
            addCriterion("page_json in", values, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonNotIn(List<String> values) {
            addCriterion("page_json not in", values, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonBetween(String value1, String value2) {
            addCriterion("page_json between", value1, value2, "pageJson");
            return (Criteria) this;
        }

        public Criteria andPageJsonNotBetween(String value1, String value2) {
            addCriterion("page_json not between", value1, value2, "pageJson");
            return (Criteria) this;
        }

        public Criteria andSJsonIsNull() {
            addCriterion("s_json is null");
            return (Criteria) this;
        }

        public Criteria andSJsonIsNotNull() {
            addCriterion("s_json is not null");
            return (Criteria) this;
        }

        public Criteria andSJsonEqualTo(String value) {
            addCriterion("s_json =", value, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonNotEqualTo(String value) {
            addCriterion("s_json <>", value, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonGreaterThan(String value) {
            addCriterion("s_json >", value, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonGreaterThanOrEqualTo(String value) {
            addCriterion("s_json >=", value, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonLessThan(String value) {
            addCriterion("s_json <", value, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonLessThanOrEqualTo(String value) {
            addCriterion("s_json <=", value, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonLike(String value) {
            addCriterion("s_json like", value, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonNotLike(String value) {
            addCriterion("s_json not like", value, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonIn(List<String> values) {
            addCriterion("s_json in", values, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonNotIn(List<String> values) {
            addCriterion("s_json not in", values, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonBetween(String value1, String value2) {
            addCriterion("s_json between", value1, value2, "sJson");
            return (Criteria) this;
        }

        public Criteria andSJsonNotBetween(String value1, String value2) {
            addCriterion("s_json not between", value1, value2, "sJson");
            return (Criteria) this;
        }

        public Criteria andExecMsIsNull() {
            addCriterion("exec_ms is null");
            return (Criteria) this;
        }

        public Criteria andExecMsIsNotNull() {
            addCriterion("exec_ms is not null");
            return (Criteria) this;
        }

        public Criteria andExecMsEqualTo(Integer value) {
            addCriterion("exec_ms =", value, "execMs");
            return (Criteria) this;
        }

        public Criteria andExecMsNotEqualTo(Integer value) {
            addCriterion("exec_ms <>", value, "execMs");
            return (Criteria) this;
        }

        public Criteria andExecMsGreaterThan(Integer value) {
            addCriterion("exec_ms >", value, "execMs");
            return (Criteria) this;
        }

        public Criteria andExecMsGreaterThanOrEqualTo(Integer value) {
            addCriterion("exec_ms >=", value, "execMs");
            return (Criteria) this;
        }

        public Criteria andExecMsLessThan(Integer value) {
            addCriterion("exec_ms <", value, "execMs");
            return (Criteria) this;
        }

        public Criteria andExecMsLessThanOrEqualTo(Integer value) {
            addCriterion("exec_ms <=", value, "execMs");
            return (Criteria) this;
        }

        public Criteria andExecMsIn(List<Integer> values) {
            addCriterion("exec_ms in", values, "execMs");
            return (Criteria) this;
        }

        public Criteria andExecMsNotIn(List<Integer> values) {
            addCriterion("exec_ms not in", values, "execMs");
            return (Criteria) this;
        }

        public Criteria andExecMsBetween(Integer value1, Integer value2) {
            addCriterion("exec_ms between", value1, value2, "execMs");
            return (Criteria) this;
        }

        public Criteria andExecMsNotBetween(Integer value1, Integer value2) {
            addCriterion("exec_ms not between", value1, value2, "execMs");
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