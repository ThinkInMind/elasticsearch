package com.d1m.elasticsearch.service;

import java.io.IOException;

public interface ElasticsearchService {
    void update(Long id) throws IOException;
}
