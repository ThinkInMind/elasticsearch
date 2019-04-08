package com.d1m.elasticsearch.common.promotion.rule;

import lombok.Getter;
import lombok.Setter;


public enum PromotionRuleEnum {
    BUY_X_GET_Y_PERCENT_OFF("BuyXGetYPercentOff", "Buy X Get Y Percent Off"),
    BUY_X_AND_Y_GET_Z_PERCENT_OFF("BuyXAndYGetZPercentOff", "Buy X And Y Get Z Percent Off");

    @Setter
    @Getter
    private String code;
    @Setter
    @Getter
    private String desc;

    PromotionRuleEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
