package com.shubhamdeshkar.remindly.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Todo {

    @Id
    private String id;

//    @Column(nullable = false)
    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Timestamp lastModified;

    @Column(nullable = false)
    private Timestamp targetDate;

    public Todo() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public Timestamp getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Timestamp targetDate) {
        this.targetDate = targetDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
