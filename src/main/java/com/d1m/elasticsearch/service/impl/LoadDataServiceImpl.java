package com.d1m.elasticsearch.service.impl;

import com.alibaba.fastjson.JSON;
import com.d1m.elasticsearch.domain.entity.EstoreProduct;
import com.d1m.elasticsearch.domain.index.Goods;
import com.d1m.elasticsearch.domain.response.ProductResult;
import com.d1m.elasticsearch.domain.response.ProductSpecResult;
import com.d1m.elasticsearch.repository.EstoreProductRepository;
import com.d1m.elasticsearch.repository.GoodsRepository;
import com.d1m.elasticsearch.service.LoadDataService;
import org.apache.lucene.spatial3d.geom.GeoOutsideDistance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LoadDataServiceImpl implements LoadDataService {

    @Autowired
    private EstoreProductRepository estoreProductRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public void loadData(Integer wechatId) {
        int offset = 0;
        int pageSize = 50;
        int size = 0;
        int count = 0;
        int currentPage = 0;
        do {
            List<ProductResult> allProducts = estoreProductRepository.findProductsWithConditions(wechatId,offset,pageSize);
            List<Goods> goodsList = allProducts.stream().map(this::buildGoods)
                    .collect(Collectors.toList());
            goodsRepository.saveAll(goodsList);
            size = allProducts.size();
            currentPage ++;
            offset = currentPage* pageSize;
            count ++;
        } while (size ==50);
        System.out.println("count = " + count);
    }

    private Goods buildGoods(ProductResult productResult) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(productResult,goods);
        goods.setId(productResult.getProductId());
        StringBuffer stringBuffer = new StringBuffer();
        for (ProductSpecResult productSpecResult : productResult.getVariationProducts()) {
            stringBuffer.append(productSpecResult.getSku() + " ");
        }
        stringBuffer.append(productResult.getProductCode()).append(" ").append(productResult.getProductName());
        goods.setAll(stringBuffer.toString());
        goods.setSkus(JSON.toJSONString(productResult.getVariationProducts()));
        System.out.println(goods);
        return goods;
    }
}
