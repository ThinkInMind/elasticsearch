package com.d1m.elasticsearch.domain.response;

import com.alibaba.fastjson.JSONObject;
import com.d1m.elasticsearch.domain.entity.EstoreProductImage;
import com.d1m.elasticsearch.domain.entity.EstoreProductTag;
import com.d1m.elasticsearch.util.mybatis.JsonTypeHandler;
import lombok.Data;
import org.springframework.data.mybatis.annotations.JdbcType;
import org.springframework.data.mybatis.annotations.TypeHandler;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by D1M on 2018/3/19.
 */
@Data
public class ProductResult implements Serializable{

    private Long productId;

    private String description;

    private String productName;

    private Integer hasDiscount;

    private String productCode;

    private Integer hasVariants;

    private Integer inWishList;

    private BigDecimal marketPrice;

    private BigDecimal salePrice;

    private Integer stock;


    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject promotions;

    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject extAttr;

    private Timestamp createAt;

    private Timestamp modifyAt;

    private Byte status;

    private Long wechatId;

    private Long saleId;

    private Byte onSale;

    private Byte deliveryFree;

    private Long deliveryTplId;



    //    以下是spec 的相关字段

    private String sku;

    private String specId;

    private Byte specType;

    private Integer productLimit;

    private String currency;

    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject specMeta;

    /**
     * 规格值（JSON格式）
     */
    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject specValue;

    /**
     * 规格值（JSON格式）
     */
    @TypeHandler(JsonTypeHandler.class)
    @JdbcType(org.apache.ibatis.type.JdbcType.VARCHAR)
    private JSONObject sizeChartCode;



    private List<EstoreProductImage> images;

    private List<EstoreProductTag> tags;

    private List<ProductSpecResult> variationProducts;

    private List<ProductResult> relatedProducts;

    private List<EstoreProductCatalogResult> catalogs;

    private List<EstoreProductCategoryResult> categories;

    private Integer seq;

    private String subTitle;

    private Byte productType;
}
