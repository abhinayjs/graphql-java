package com.graphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqljava.domain.Link;
import com.graphqljava.domain.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkCreator implements GraphQLMutationResolver {

    @Autowired
    private final LinkRepository linkRepository;

    public LinkCreator(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        linkRepository.saveLink(newLink);
        return newLink;
    }
}
