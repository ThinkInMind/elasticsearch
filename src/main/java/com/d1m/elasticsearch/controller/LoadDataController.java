package com.d1m.elasticsearch.controller;


import com.alibaba.fastjson.JSONObject;
import com.d1m.elasticsearch.common.multitenancy.TenantContext;
import com.d1m.elasticsearch.service.LoadDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("load-data")
public class LoadDataController {

    @Autowired
    private LoadDataService loadDataService;
    @RequestMapping("buildGoods/{wechatId}")
    public JSONObject loadData(@PathVariable Integer wechatId){

        TenantContext.setCurrentTenant(wechatId);
        this.loadDataService.loadData(wechatId);

        return null;
    }
}
