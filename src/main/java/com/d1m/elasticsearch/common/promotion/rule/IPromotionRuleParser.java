package com.d1m.elasticsearch.common.promotion.rule;


import com.d1m.elasticsearch.common.promotion.PromotionProductParam;

public interface IPromotionRuleParser<T extends PromotionRuleBase> {
    PromotionRuleEnum getRuleType();
    T parseRule(String ruleString);
    boolean applyRule(String ruleString, PromotionProductParam[] productParams);
}
