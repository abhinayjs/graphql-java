package com.graphqljava.domain;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinkRepository {

    @Autowired
    MongoDbFactory mongoDbFactory;

    private final MongoCollection<Document> links;

    public LinkRepository() {
        this.links = mongoDbFactory.getDb().getCollection("links");
    }

    public Link findById(String id) {
        Document doc = links.find(eq("_id", new ObjectId(id))).first();
        return link(doc);
    }

    public List<Link> geAllLinks() {
        List<Link> allLinks = new ArrayList<>();
        for (Document doc: links.find()) {
            allLinks.add(link(doc));
        }
        return allLinks;
    }

    public void saveLink(Link link) {
        Document doc = new Document();
        doc.append("url", link.getUrl());
        doc.append("description", link.getDescription());
        links.insertOne(doc);
    }

    private Link link(Document doc) {
        return new Link(
                doc.get("_id").toString(),
                doc.getString("url"),
                doc.getString("description")
        );
    }
}

