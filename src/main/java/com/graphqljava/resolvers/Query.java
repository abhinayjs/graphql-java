package com.graphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.domain.Link;
import com.graphqljava.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private LinkRepository linkRepository;

    public List<Link> allLinks() {
        return linkRepository.findAll();
    }
}
