package com.d1m.elasticsearch.service.impl;

import com.d1m.elasticsearch.domain.index.Goods;
import com.d1m.elasticsearch.domain.param.PageParam;
import com.d1m.elasticsearch.domain.request.SearchParam;
import com.d1m.elasticsearch.repository.GoodsRepository;
import com.d1m.elasticsearch.service.SearchService;
import com.d1m.elasticsearch.util.PageUtil.PageBean;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.join.query.JoinQueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public PageBean EsSearch(PageParam<SearchParam> pageParam) throws ParseException {
        String key = pageParam.getSearchParam().getKey();
        if (key == null || key.trim().equals("")) {
            /**  if there is no query condition, return all products */
            Page<Goods> all = goodsRepository.findAll(PageRequest.of(pageParam.getCurrentPage(), pageParam.getPageSize()));
            Long count = goodsRepository.count();
            return PageBean.createPageBean(pageParam.getCurrentPage(),pageParam.getPageSize(),count,all.getContent());
        }

//        SearchRequest searchRequest = new SearchRequest();
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchRequest.source(sourceBuilder);
//        SearchResponse searchResponse = new SearchResponse();


//        QueryBuilder joinQueryBuilder = JoinQueryBuilders.hasChildQuery(
//                "user",
//                QueryBuilders.matchAllQuery(),
//                ScoreMode.None
//        );
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder()
                .withQuery(buildBasicQuery(pageParam.getSearchParam()));
//        /** create a query builder */
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//        /** get basic query conditions */
//        QueryBuilder basicBuilder = buildBasicQuery(pageParam.getSearchParam());
//        queryBuilder.withQuery(basicBuilder);
//        /** pagination */
//        searchWithPageAndSort(queryBuilder, pageParam);
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        Page<Goods> searchResults = elasticsearchTemplate.queryForPage(searchQuery, Goods.class);
//        List<Goods> content = searchResults.getContent();
//
        /**  using elasticsearchTemplate to query the count of result, index entity is required in parameters */
        long count = elasticsearchTemplate.count(queryBuilder.build(),Goods.class);
        queryBuilder.withPageable(PageRequest.of(pageParam.getCurrentPage(),pageParam.getPageSize()));
        queryBuilder.withSort(SortBuilders.fieldSort(pageParam.getSortBy()).order(pageParam.getDescending()? SortOrder.ASC:SortOrder.DESC));
        Page<Goods> searchResults = goodsRepository.search(queryBuilder.build());
        List<Goods> contents = searchResults.getContent();
        PageBean pageBean = PageBean.createPageBean(pageParam.getCurrentPage(), pageParam.getPageSize(), count, contents);
        return pageBean;
    }

    /**
     * 基本查询构建
     * @param searchParam
     * @return
     */
    private QueryBuilder buildBasicQuery(SearchParam searchParam) throws ParseException {
        BoolQueryBuilder outerQueryBuilder = QueryBuilders.boolQuery();
        BoolQueryBuilder innerQueryBuilder = QueryBuilders.boolQuery();
        /**
         * In this part, we need to define two queryBuilders in consequence of
         * two fields exist in elasticsearch when we make a query,so that we can
         * use double should conditions to get results what we need
         */
        innerQueryBuilder.should(QueryBuilders.wildcardQuery("keyword",searchParam.getKey()+"*"));
        innerQueryBuilder.should(QueryBuilders.matchQuery("all",searchParam.getKey()));
        outerQueryBuilder.must(innerQueryBuilder);
        String startTime = searchParam.getStartTime();
        String endTime = searchParam.getEndTime();
        if (startTime != null && endTime != null) {
            long start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(searchParam.getStartTime()).getTime();
            long end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(searchParam.getEndTime()).getTime();
            if (end >= start) {
                outerQueryBuilder.must(QueryBuilders.rangeQuery("createAt").gte(start).lte(end));
            }
        }
        return outerQueryBuilder;
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
