package com.d1m.elasticsearch.domain.response;

import com.alibaba.fastjson.JSONObject;
import com.d1m.elasticsearch.common.promotion.IPromotionProduct;
import com.d1m.elasticsearch.domain.entity.EstoreProductImage;
import com.d1m.elasticsearch.util.mybatis.JsonTypeHandler;
import lombok.Data;
import org.springframework.data.mybatis.annotations.JdbcType;
import org.springframework.data.mybatis.annotations.TypeHandler;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by D1M on 2018/3/20.
 */
@Data
public class ProductSimpleResult  implements Serializable, IPromotionProduct {

    private Long productId;

    /**
     * 规格类型（0：统一规格；1：多规格）
     */
    private Byte specType;


    /**
     * 市场价，单位：元
     */

    private BigDecimal marketPrice;

    /**
     * 实际销售价格，单位：元
     */
    private BigDecimal salePrice;

    /**
     * 积分数
     */
    private Integer point;

    /**
     * 库存数
     */
    private Integer stock;


    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 修改时间
     */
    private Date modifyAt;

    private String productCode;

    /**
     * 状态（1：正常；0：删除）
     */
    private Byte status;
    /**
     * 微信ID
     */
    private Long wechatId;

    private List<EstoreProductImage> images;

    private String productName;

    private String description;

    private Integer saleId;

    private Integer onSale;

    private String currency;

    private Integer inWishList;

    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject specMeta;


    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject sizeChartCode;



    private List<EstoreProductTagResult> tags;

    private List<EstoreProductCategoryResult> categories;

    private List<EstoreProductCatalogResult> catalogs;

    private String subTitle;

    private Byte productType;
}