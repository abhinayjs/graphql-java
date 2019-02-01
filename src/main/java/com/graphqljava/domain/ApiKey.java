package com.graphqljava.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "apikeys")
public class ApiKey {

    String id;
    String key;
    String role = "admin";

    public ApiKey(String id, String key) {
        this.id = id;
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return id+","+key+","+role;
    }
}
