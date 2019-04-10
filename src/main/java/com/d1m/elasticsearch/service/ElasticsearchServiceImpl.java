package com.d1m.elasticsearch.service;


import com.d1m.elasticsearch.common.RestClientFactory;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {


    /**
     * ES 数据更新
     * @param id
     */
    @Override
    public void update(Long id) throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        builder.field("productCode","100");
        builder.endObject();
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("goods");
        updateRequest.id("14");
        updateRequest.type("docs");
        updateRequest.doc(builder);
        RestHighLevelClient client = RestClientFactory.getHighLevelClient();
        client.update(updateRequest);

    }
}
