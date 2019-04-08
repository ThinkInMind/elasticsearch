package com.d1m.elasticsearch.common.promotion;

public enum PromotionProductFieldTypeEnum {
    PRODUCT_ID(0, "Product ID"),
    MARKET_PRICE(1, "Market Price"),
    CALCULATED_PRICE(2, "Calculated Price"),
    PROMOTION_TYPE(3, "Calculated Price");

    private int code;
    private String desc;


    PromotionProductFieldTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
