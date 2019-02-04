package com.graphqljava.domain;

import java.time.ZonedDateTime;

public class Vote {

    private String id;
    private ZonedDateTime createdAt;
    private String userId;
    private String linkId;

    public Vote(ZonedDateTime createdAt, String userId, String linkId) {
        this.createdAt = createdAt;
        this.userId = userId;
        this.linkId = linkId;
    }

    public String getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public String getLinkId() {
        return linkId;
    }
}
