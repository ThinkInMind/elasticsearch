package com.d1m.elasticsearch.domain.entity;

import com.d1m.elasticsearch.common.SearchSerializableId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class EstoreProductTag extends SearchSerializableId<Integer> {

    /**
     * 产品销售ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 标签ID
     */
    @Column(name = "tag_id")
    private Long tagId;

    /**
     * 微信ID
     */
    @Column(name = "wechat_id")
    private Integer wechatId;


}