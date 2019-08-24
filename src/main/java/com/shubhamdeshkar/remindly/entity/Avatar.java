package com.shubhamdeshkar.remindly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Avatar {

    @Id
    private String id;

    @Column(nullable = false)
    private String url;

    public Avatar() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
