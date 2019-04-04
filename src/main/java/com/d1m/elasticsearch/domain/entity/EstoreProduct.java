package com.d1m.elasticsearch.domain.entity;

import com.alibaba.fastjson.JSONObject;
import com.d1m.elasticsearch.common.SearchSerializableId;
import com.d1m.elasticsearch.util.mybatis.JsonTypeHandler;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mybatis.annotations.JdbcType;
import org.springframework.data.mybatis.annotations.TypeHandler;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class EstoreProduct extends SearchSerializableId<Long> {


    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 预留：格式化的扩展属性，JSON格式
     */
    @Column(name = "ext_attr")
    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject extAttr;

    /**
     * 规格类型（0：统一规格；1：多规格）
     */
    @Column(name = "spec_type")
    private Byte specType;

    /**
     * 规格元数据（多规格使用，JSON格式）
     */
    @Column(name = "spec_meta")
    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject specMeta;

    /**
     * 创建时间
     */
    @Column(name = "create_at")
    private Date createAt;

    /**
     * 修改时间
     */
    @Column(name = "modify_at")
    private Date modifyAt;

    /**
     * 状态（1：正常；0：删除）
     */
    private Byte status;

    /**
     * 微信ID
     */
    @Column(name = "wechat_id")
    private Integer wechatId;

    /**
     * 商品描述
     */
    private String description;

    /*
    * 副标题
     */
    private String subTitle;

    private double marketPrice;

    private double price;

    private String sizeChartCode;

    private Integer seq;

    /**
     * 上架状态（1：上架；0：下架）
     */
    @Column(name = "on_sale")
    private Byte onSale;

    @Column(name = "id")
    private Long productId;

    @Column(name = "product_type")
    private Byte productType;

}