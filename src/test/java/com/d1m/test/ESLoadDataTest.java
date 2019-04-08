package com.d1m.test;

import com.d1m.elasticsearch.ElasticsearchApplication;
import com.d1m.elasticsearch.repository.EstoreProductRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchApplication.class)
public class ESLoadDataTest {

    @Autowired
    private EstoreProductRepository estoreProductRepository;

}
