package com.d1m.elasticsearch.repository;

import com.d1m.elasticsearch.domain.entity.EstoreProduct;
import org.springframework.data.mybatis.repository.annotation.Query;
import org.springframework.data.mybatis.repository.support.MybatisRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface EstoreProductRepository extends MybatisRepository<EstoreProduct,Long>{

    @Query
    EstoreProduct findo(@Param("name")String name, @Param("code")String code);

}
