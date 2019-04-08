package com.d1m.elasticsearch.common.promotion.rule;

import lombok.Data;

import java.io.Serializable;

@Data
public class PromotionRuleBase  implements Serializable{
    private String type;
    private String description;
}
