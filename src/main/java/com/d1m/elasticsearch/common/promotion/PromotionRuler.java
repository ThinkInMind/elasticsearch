package com.d1m.elasticsearch.common.promotion;

import com.d1m.elasticsearch.common.promotion.rule.IPromotionRuleParser;
import com.d1m.elasticsearch.common.promotion.rule.PromotionRuleBase;
import com.d1m.elasticsearch.domain.entity.EstorePromotion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PromotionRuler {
    private Map<String, IPromotionRuleParser> ruleParsers;

    public PromotionRuler() {
        this.ruleParsers = new HashMap<>();
    }

    public void addRuleParser(IPromotionRuleParser ruleParser) {
        this.ruleParsers.put(ruleParser.getRuleType().getCode(), ruleParser);
    }

    public boolean applyPromotion(PromotionProductParam[] products, List<EstorePromotion> promotions) {
        boolean appliedPromotion = false;
        promotions.sort((EstorePromotion p1, EstorePromotion p2) -> (p1.getRank() - p2.getRank()));
        for (int i = 0; i < promotions.size(); i++) {
            EstorePromotion promotion = promotions.get(i);
            IPromotionRuleParser ruleParser = ruleParsers.get(promotion.getType());
            boolean temp = ruleParser.applyRule(promotion.getRule(), products);
            appliedPromotion = temp || appliedPromotion;
            if(appliedPromotion && promotion.getExclusivity() == 1) {
                break;
            }
        }
        return appliedPromotion;
    }

    public List<PromotionRuleBase> parsePromotionRules(List<EstorePromotion> promotions) {
        List<PromotionRuleBase> promotionRules = new ArrayList<>();
        for (int i = 0; i < promotions.size(); i++) {
            EstorePromotion promotion = promotions.get(i);
            IPromotionRuleParser ruleParser = ruleParsers.get(promotion.getType());
            promotionRules.add(ruleParser.parseRule(promotion.getRule()));
        }
        return promotionRules;
    }
}
