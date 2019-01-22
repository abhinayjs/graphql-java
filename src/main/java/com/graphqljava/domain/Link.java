package com.graphqljava.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="links")
public class Link {

    private String id;
    private String url;
    private String description;

    public Link(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
