package com.d1m.elasticsearch.common.promotion.rule;

import com.alibaba.fastjson.JSON;
import com.d1m.elasticsearch.common.promotion.PromotionProductParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class RuleBuyXGetYPercentOffParser implements IPromotionRuleParser<RuleBuyXGetYPercentOff> {
    @Override
    public PromotionRuleEnum getRuleType() {
        return PromotionRuleEnum.BUY_X_GET_Y_PERCENT_OFF;
    }

    @Override
    public RuleBuyXGetYPercentOff parseRule(String ruleString) {
        RuleBuyXGetYPercentOff rule = JSON.parseObject(ruleString, RuleBuyXGetYPercentOff.class);
        return rule;
    }

    @Override
    public boolean applyRule(String ruleString, PromotionProductParam[] productParams) {
        RuleBuyXGetYPercentOff rule = parseRule(ruleString);
        boolean promotionQualified = false;
        List<Long> qualifiedProducts =  Arrays.asList(rule.getQualifiedProducts());

        for (int i = 0; i < productParams.length; i++) {
            if(qualifiedProducts.contains(productParams[i].getProductId()) || qualifiedProducts.size() == 0) {
                promotionQualified = true;
                break;
            }
        }
        if(promotionQualified && productParams.length >= rule.getMinAmount()) {
            for (int i = 0; i < productParams.length; i++) {
                productParams[i].setCalculatedPrice(productParams[i].getMarketPrice() * rule.getDiscount());
                productParams[i].setPromotionType(this.getRuleType().getCode());
            }
            return true;
        }
        return false;
    }

}
