package com.d1m.elasticsearch.domain.index;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.sql.Timestamp;
import java.util.List;


@Document(indexName = "goods",type = "product",shards = 5,replicas = 1)
@Data
public class Product {
    @Id
    private Long id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String code;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String description;

    @Field(type = FieldType.Keyword)
    private String ext_attr;

    @Field(type = FieldType.Keyword)
    private String spec_meta;

    @Field(type = FieldType.Long)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp create_at;

    @Field(type = FieldType.Long)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp modify_at;

    @Field(type = FieldType.Double)
    private Double market_price;

    @Field(type = FieldType.Double)
    private Double price;

    @Transient
    private List<ProductSpec> productSpecList;
}
