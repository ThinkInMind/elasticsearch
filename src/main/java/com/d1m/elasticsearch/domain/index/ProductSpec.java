package com.d1m.elasticsearch.domain.index;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.sql.Timestamp;

@Document(indexName = "goods",type = "productSpec")
@Data
public class ProductSpec {

    @Id
    private Long id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String sku;
    private Byte spec_type;
    @Field(type = FieldType.Keyword)
    private String spec_value;
    @Field(type = FieldType.Double)
    private Double market_price;
    @Field(type = FieldType.Double)
    private Double price;
    private int stock;
    @Field(type = FieldType.Long)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp create_at;
    @Field(type = FieldType.Long)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp modify_at;
    private Byte status;
    @Field(type = FieldType.Keyword)
    private Long product_id;
    private int frozen_stock;

}
