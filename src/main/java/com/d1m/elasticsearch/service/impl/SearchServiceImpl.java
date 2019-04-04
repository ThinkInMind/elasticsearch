package com.d1m.elasticsearch.service.impl;

import com.d1m.elasticsearch.domain.index.Product;
import com.d1m.elasticsearch.domain.param.PageParam;
import com.d1m.elasticsearch.domain.request.SearchParam;
import com.d1m.elasticsearch.repository.GoodsRepository;
import com.d1m.elasticsearch.service.SearchService;
import com.d1m.elasticsearch.util.PageUtil.PageBean;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.join.query.JoinQueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public PageBean EsSearch(PageParam<SearchParam> pageParam) {
        String key = pageParam.getSearchParam().getKey();
        if (key == null || key.trim().equals("")) {
            return null;
        }

//        SearchRequest searchRequest = new SearchRequest();
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchRequest.source(sourceBuilder);
//        SearchResponse searchResponse = new SearchResponse();


        QueryBuilder joinQueryBuilder = JoinQueryBuilders.hasChildQuery(
                "user",
                QueryBuilders.matchAllQuery(),
                ScoreMode.None
        );
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(buildBasicQuery(pageParam.getSearchParam()))
//                .withPageable(PageRequest.of(pageParam.getCurrentPage(), pageParam.getPageSize()))
                .withSort(SortBuilders.fieldSort(pageParam.getSortBy()).order(pageParam.getDescending() ? SortOrder.DESC : SortOrder.ASC))
                .build();
//        /** create a query builder */
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//        /** get basic query conditions */
//        QueryBuilder basicBuilder = buildBasicQuery(pageParam.getSearchParam());
//        queryBuilder.withQuery(basicBuilder);
//        /** pagination */
//        searchWithPageAndSort(queryBuilder, pageParam);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        Page<Product> searchResults = elasticsearchTemplate.queryForPage(searchQuery, Product.class);
        List<Product> content = searchResults.getContent();

//        Page<Product> searchResults = goodsRepository.search(queryBuilder.build());
        List<Product> contents = searchResults.getContent();
        return null;
    }

    private QueryBuilder buildBasicQuery(SearchParam searchParam) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery("name", searchParam.getKey()));
        Long startTime = searchParam.getStartTime();
        Long endTime = searchParam.getEndTime();
        if (startTime != null && endTime != null && endTime >= startTime) {
            queryBuilder.must(QueryBuilders.rangeQuery("create_at").gte(searchParam.getStartTime()).lte(searchParam.getEndTime()));
        }
//        queryBuilder.must(QueryBuilders.termQuery("code", searchParam.getKey()));
        return queryBuilder;
    }

    private void searchWithPageAndSort(NativeSearchQueryBuilder queryBuilder, PageParam<SearchParam> pageParam) {
        int currentPage = pageParam.getCurrentPage();
        int pageSize = pageParam.getPageSize();
//        queryBuilder.withPageable(PageRequest.of(currentPage, pageSize));
        String sortBy = pageParam.getSortBy();
        Boolean descending = pageParam.getDescending();
        if (StringUtils.isNotBlank(sortBy)) {
            queryBuilder.withSort(SortBuilders.fieldSort(sortBy).order(descending ? SortOrder.DESC : SortOrder.ASC));
        }
    }
}
