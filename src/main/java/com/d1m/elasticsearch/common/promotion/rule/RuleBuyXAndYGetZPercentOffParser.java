package com.d1m.elasticsearch.common.promotion.rule;

import com.alibaba.fastjson.JSON;
import com.d1m.elasticsearch.common.promotion.PromotionProductParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class RuleBuyXAndYGetZPercentOffParser implements IPromotionRuleParser<RuleBuyXAndYGetZPercentOff> {
    @Override
    public PromotionRuleEnum getRuleType() {
        return PromotionRuleEnum.BUY_X_AND_Y_GET_Z_PERCENT_OFF;
    }

    @Override
    public RuleBuyXAndYGetZPercentOff parseRule(String ruleString) {
        RuleBuyXAndYGetZPercentOff rule = JSON.parseObject(ruleString, RuleBuyXAndYGetZPercentOff.class);
        return rule;
    }

    @Override
    public boolean applyRule(String ruleString, PromotionProductParam[] productParams) {
        RuleBuyXAndYGetZPercentOff rule = parseRule(ruleString);
        boolean xQualified = false;
        boolean yQualified = false;
        int xCount = 0;
        int yCount = 0;
        List<Long> qualifiedProductsX =  Arrays.asList(rule.getQualifiedProductsX());
        List<Long> qualifiedProductsY =  Arrays.asList(rule.getQualifiedProductsY());

        for (int i = 0; i < productParams.length; i++) {
            if(qualifiedProductsX.contains(productParams[i].getProductId()) || qualifiedProductsX.size() == 0) {
                xCount++;
            }
            else if(qualifiedProductsY.contains(productParams[i].getProductId()) || qualifiedProductsY.size() == 0) {
                yCount++;

            }

        }

        xQualified = xCount >= rule.getMinAmountX();
        yQualified = yCount >= rule.getMinAmountY();

        if(xQualified && yQualified) {
            for (int i = 0; i < productParams.length; i++) {
                productParams[i].setCalculatedPrice(productParams[i].getMarketPrice() * rule.getDiscount());
                productParams[i].setPromotionType(this.getRuleType().getCode());
            }
            return true;
        }
        return false;
    }

}
