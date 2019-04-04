package com.d1m.elasticsearch.domain.index;

import com.d1m.elasticsearch.domain.response.EstoreProductCategoryResult;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "goods",type = "docs",shards = 5,replicas = 1)
public class Goods {
    @Id
    private Long id;//spuId
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String all;//可以搜索的关键短语
    @Field(type = FieldType.Text)
    private String skus;//当前spu下的多个sku json格式
    private List<EstoreProductCategoryResult> categories;

}
