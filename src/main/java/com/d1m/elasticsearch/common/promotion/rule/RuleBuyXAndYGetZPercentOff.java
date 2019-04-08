package com.d1m.elasticsearch.common.promotion.rule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuleBuyXAndYGetZPercentOff extends PromotionRuleBase  {
    private int minAmountX;
    private int minAmountY;
    private double discount;
    private Long[] qualifiedProductsX;
    private Long[] qualifiedProductsY;
}
