package com.d1m.elasticsearch.repository;


import com.d1m.elasticsearch.domain.index.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRepository extends ElasticsearchRepository<Item,Long>{
}
