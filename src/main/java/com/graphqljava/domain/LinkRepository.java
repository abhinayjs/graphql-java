package com.graphqljava.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinkRepository {

    private final List<Link> links;

    public LinkRepository() {
        links = new ArrayList<>();
        links.add(new Link("www.google.com", "Google"));
        links.add(new Link("www.amazon.com", "Amazon"));
    }

    public List<Link> geAllLinks() {
        return links;
    }

    public void saveLink(Link link) {
        links.add(link);
    }
}

