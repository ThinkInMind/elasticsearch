package com.d1m.elasticsearch.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class MultiTenant implements Persistable<Integer> {

    @Id
    private Integer id;

    @Column(name = "jdbc_url")
    private String jdbcUrl;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "comments")
    private String comments;

    @Override
    public boolean isNew() {
        return false;
    }
}