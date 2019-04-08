package com.d1m.elasticsearch.repository;

import com.d1m.elasticsearch.domain.response.ProductSpecResult;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstoreProductSpecRepository {

    List<ProductSpecResult> selectProductSpecBySpecIdAndProductId(@Param("specId") Long productSpecId, @Param("productId") Long productId);
}
