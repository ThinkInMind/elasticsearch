package com.d1m.elasticsearch.repository;

import com.d1m.elasticsearch.domain.index.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface GoodsRepository extends ElasticsearchRepository<Goods,Long>{


}
