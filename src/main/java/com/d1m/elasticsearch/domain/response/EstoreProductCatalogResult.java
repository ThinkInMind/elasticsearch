package com.d1m.elasticsearch.domain.response;

import lombok.Data;

@Data
public class EstoreProductCatalogResult {

    private Integer productId;
    private Integer catalogId;
    private String name;
    private Integer parentId;
    private Integer wechatId;
    private String mainImageUrl;
    private String description;
    private Integer seq;
    private Integer status;

}