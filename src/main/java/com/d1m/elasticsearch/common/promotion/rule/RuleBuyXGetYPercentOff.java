package com.d1m.elasticsearch.common.promotion.rule;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RuleBuyXGetYPercentOff extends PromotionRuleBase implements Serializable {
    private int minAmount;
    private double discount;
    private Long[] qualifiedProducts;
}
