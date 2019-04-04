package com.d1m.elasticsearch.domain.param;


import lombok.Data;

@Data
public class PageParam<T> extends BaseParam {

    private Integer currentPage;

    private Integer pageSize;

    private String sortBy;

    private String direction;

    private Boolean descending;

    private T searchParam;

}
