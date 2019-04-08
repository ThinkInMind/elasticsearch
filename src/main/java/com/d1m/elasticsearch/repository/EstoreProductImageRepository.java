package com.d1m.elasticsearch.repository;

import com.d1m.elasticsearch.domain.entity.EstoreProductImage;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstoreProductImageRepository {

    List<EstoreProductImage> selectProductImageListByProductId(@Param("wechatId") Integer wechatId, @Param("id") Long id);

    List<EstoreProductImage> selectProductSpecImageListBySpecId(@Param("wechatId") Integer wechatId, @Param("id") Long id);
}
