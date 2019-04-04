package com.d1m.elasticsearch.domain.request;


import lombok.Data;

@Data
public class SearchParam {

    private String key;//搜索关键字

    private Long startTime;

    private Long endTime;

}
