package com.d1m.elasticsearch.domain.response;

import com.d1m.elasticsearch.common.SearchSerializableId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstoreProductCategoryResult extends SearchSerializableId<Integer>{

    private Long productId;
    private Long categoryId;
    private Integer wechatId;
    private String mainImageUrl;
    private String description;
    private String name;
}
