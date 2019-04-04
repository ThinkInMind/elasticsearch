package com.d1m.elasticsearch.service;

import com.d1m.elasticsearch.domain.param.PageParam;
import com.d1m.elasticsearch.domain.request.SearchParam;
import com.d1m.elasticsearch.util.PageUtil.PageBean;

public interface SearchService {
    PageBean EsSearch(PageParam<SearchParam> pageParam);
}
