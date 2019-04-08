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
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class EstoreProductSpec extends SearchSerializableId<Integer> {

    /**
     * 货号、商品编号
     */
    private String sku;

    /**
     * 规格类型（0：统一规格；1：多规格）
     */
    @Column(name = "spec_type")
    private Byte specType;

    /**
     * 规格值（JSON格式）
     */
    @Column(name = "spec_value")
    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject specValue;

    /**
     * 市场价，单位：元
     */
    @Column(name = "market_price")
    private BigDecimal marketPrice;

    /**
     * 实际销售价格，单位：元
     */
    private BigDecimal price;

    /**
     * 积分数
     */
    private Integer point=0;

    /**
     * 库存数
     */
    private Integer stock;

    /**
     * 重量
     */
    private Double weight;

    /**
     * 体积
     */
    private Double volume;

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

    @Column(name = "product_id")
    private Long productId;

    /**
     * 微信ID
     */
    @Column(name = "wechat_id")
    private Integer wechatId;

    @Column(name = "seq")
    private Integer seq;

    @Column(name = "description")
    private String description;


    @Column(name="sub_title")
    private String subTitle;


    @Column(name="spec_name")
    private String specName;


    @Column(name = "ext_attr")
    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject extAttr;

    @Column(name="id")
    private Long productSpecId;

    @Column(name = "syn_stock")
    private Byte synStock;

}