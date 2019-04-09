package com.d1m.elasticsearch.domain.index;

import com.alibaba.fastjson.JSONObject;
import com.d1m.elasticsearch.domain.entity.EstoreProductImage;
import com.d1m.elasticsearch.domain.response.EstoreProductCatalogResult;
import com.d1m.elasticsearch.domain.response.EstoreProductCategoryResult;
import com.d1m.elasticsearch.util.mybatis.JsonTypeHandler;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.mybatis.annotations.JdbcType;
import org.springframework.data.mybatis.annotations.TypeHandler;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Document(indexName = "goods",type = "docs",shards = 5,replicas = 1)
@Data
public class Goods {
    @Id
    private Long id;//spuId
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String all;//可以搜索的关键短语,分词
    @Field(type = FieldType.Keyword)
    private String skus;//当前spu下的多个sku json格式

    @Field(type = FieldType.Keyword)
    private String keyword;

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

    @Field(type = FieldType.Long)
    private Timestamp createAt;

    @Field(type = FieldType.Long)
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

    private List<EstoreProductCategoryResult> categories;

    private List<EstoreProductCatalogResult> catalogs;

    private Integer seq;

    private String subTitle;

    private Byte productType;

}
