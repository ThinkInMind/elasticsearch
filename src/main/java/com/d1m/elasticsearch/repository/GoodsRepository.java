package com.d1m.elasticsearch.repository;

import com.d1m.elasticsearch.domain.index.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface GoodsRepository extends ElasticsearchRepository<Product,Long>{

}
