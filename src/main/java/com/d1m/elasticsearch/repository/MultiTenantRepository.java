package com.d1m.elasticsearch.repository;

import java.util.List;
import java.util.Map;

public interface MultiTenantRepository{

    List<Map<String,Object>> listAll();

}