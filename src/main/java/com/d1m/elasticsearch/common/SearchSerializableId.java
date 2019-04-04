package com.d1m.elasticsearch.common;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

@Data
public abstract class SearchSerializableId<ID extends Serializable> implements Persistable<ID>{

    @Id
    protected ID id;

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }
}
