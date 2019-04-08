package com.d1m.elasticsearch.common.promotion;

import lombok.Data;

@Data
public class PromotionProductParam implements IPromotionProduct {
    private Long productId;
    private double marketPrice;
    private double calculatedPrice;
    private String promotionType;

}
