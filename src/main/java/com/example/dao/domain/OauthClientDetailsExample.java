package com.example.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class OauthClientDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OauthClientDetailsExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNull() {
            addCriterion("client_secret is null");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNotNull() {
            addCriterion("client_secret is not null");
            return (Criteria) this;
        }

        public Criteria andClientSecretEqualTo(String value) {
            addCriterion("client_secret =", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotEqualTo(String value) {
            addCriterion("client_secret <>", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThan(String value) {
            addCriterion("client_secret >", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThanOrEqualTo(String value) {
            addCriterion("client_secret >=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThan(String value) {
            addCriterion("client_secret <", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThanOrEqualTo(String value) {
            addCriterion("client_secret <=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLike(String value) {
            addCriterion("client_secret like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotLike(String value) {
            addCriterion("client_secret not like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretIn(List<String> values) {
            addCriterion("client_secret in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotIn(List<String> values) {
            addCriterion("client_secret not in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretBetween(String value1, String value2) {
            addCriterion("client_secret between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotBetween(String value1, String value2) {
            addCriterion("client_secret not between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andExpireInIsNull() {
            addCriterion("expire_in is null");
            return (Criteria) this;
        }

        public Criteria andExpireInIsNotNull() {
            addCriterion("expire_in is not null");
            return (Criteria) this;
        }

        public Criteria andExpireInEqualTo(Integer value) {
            addCriterion("expire_in =", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInNotEqualTo(Integer value) {
            addCriterion("expire_in <>", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInGreaterThan(Integer value) {
            addCriterion("expire_in >", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInGreaterThanOrEqualTo(Integer value) {
            addCriterion("expire_in >=", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInLessThan(Integer value) {
            addCriterion("expire_in <", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInLessThanOrEqualTo(Integer value) {
            addCriterion("expire_in <=", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInIn(List<Integer> values) {
            addCriterion("expire_in in", values, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInNotIn(List<Integer> values) {
            addCriterion("expire_in not in", values, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInBetween(Integer value1, Integer value2) {
            addCriterion("expire_in between", value1, value2, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInNotBetween(Integer value1, Integer value2) {
            addCriterion("expire_in not between", value1, value2, "expireIn");
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