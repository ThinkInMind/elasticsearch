package com.d1m.elasticsearch.common.promotion.rule;

import com.d1m.elasticsearch.common.promotion.PromotionRuler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionRulerFactory {


    private PromotionRuler promotionRuler;
    private RuleBuyXGetYPercentOffParser ruleBuyXGetYPercentoffParser;
    private RuleBuyXAndYGetZPercentOffParser ruleBuyXAndYGetZPercentOffParser;

    @Autowired
    public PromotionRulerFactory(PromotionRuler promotionRuler, RuleBuyXGetYPercentOffParser ruleBuyXGetYPercentoffParser, RuleBuyXAndYGetZPercentOffParser ruleBuyXAndYGetZPercentOffParser) {
        this.promotionRuler = promotionRuler;
        this.ruleBuyXGetYPercentoffParser = ruleBuyXGetYPercentoffParser;
        this.ruleBuyXAndYGetZPercentOffParser = ruleBuyXAndYGetZPercentOffParser;
    }

    public PromotionRuler getPromotionRuler() {
        promotionRuler.addRuleParser(ruleBuyXGetYPercentoffParser);
        promotionRuler.addRuleParser(ruleBuyXAndYGetZPercentOffParser);
        return promotionRuler;
    }

}
