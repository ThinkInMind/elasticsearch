package com.d1m.elasticsearch.controller;


import com.alibaba.fastjson.JSONObject;
import com.d1m.elasticsearch.common.multitenancy.TenantContext;
import com.d1m.elasticsearch.domain.entity.EstoreProduct;
import com.d1m.elasticsearch.repository.EstoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class SearchController extends BaseController{


//    @Autowired
//    private SearchService searchService;

    @Autowired
    private EstoreProductRepository estoreProductRepository;


//    @PostMapping("query")
//    public JSONObject EsSearch(@RequestBody PageParam<SearchParam> pageParam){
//        PageBean pageBean = searchService.EsSearch(pageParam);
//        if (pageBean == null){
//        }
//        return null;
//    }

    @GetMapping("getMemberInfo/{wechatId}/{memberId}")
    public JSONObject getMemberInfo(@PathVariable("wechatId")Integer wechatId,@PathVariable("memberId")Integer memberId){
        TenantContext.setCurrentTenant(wechatId);
        EstoreProduct name = estoreProductRepository.findo("鱼子精华琼贵眼霜","SPU01");
        System.out.println("name = " + name);
        return null;
    }




}
