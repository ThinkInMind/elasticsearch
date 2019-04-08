package com.d1m.elasticsearch.repository;

import com.d1m.elasticsearch.domain.entity.EstoreProduct;
import com.d1m.elasticsearch.domain.response.ProductResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EstoreProductRepository{

    EstoreProduct findo(@Param("name") String name, @Param("code")String code);

    List<ProductResult> findProductsWithConditions(@Param("wechatId") Integer wechatId,@Param("offset")Integer offset,@Param("pageSize")Integer pageSize);
}
