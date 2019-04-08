package com.d1m.elasticsearch.domain.response;

import com.d1m.elasticsearch.common.SearchSerializableId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class EstoreProductTagResult extends SearchSerializableId<Integer> {


    private Long productId;

    private Long tagId;

    private Integer wechatId;

    private String name;

    private String tagImg;


}