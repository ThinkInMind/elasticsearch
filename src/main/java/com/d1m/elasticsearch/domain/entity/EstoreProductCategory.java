package com.d1m.elasticsearch.domain.entity;

import com.d1m.elasticsearch.common.SearchSerializableId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Getter
@Setter
@Entity
public class EstoreProductCategory extends SearchSerializableId<Integer> {

    /**
     * 产品销售ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 微信ID
     */
    @Column(name = "wechat_id")
    private Integer wechatId;

    /**
     * 目录主图片
     */
    @Column(name = "main_image_url")
    private String mainImageUrl;

    /**
     * 产品目录描述
     */
    @Column(name = "description")
    private String description;
    @Transient
    private String name;
}