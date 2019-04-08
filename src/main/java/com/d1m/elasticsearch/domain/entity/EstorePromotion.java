package com.d1m.elasticsearch.domain.entity;

import com.d1m.elasticsearch.common.SearchSerializableId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class EstorePromotion extends SearchSerializableId<Integer> {
    private String name;
    private String type;
    private String rule;
    private int rank;
    private int exclusivity;
    private int status;
    private int associateAllProduct;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private Date createDate;
    private String comments;
    private String promotionCode;
    private Integer wechatId;
}