package com.graphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.domain.Link;
import com.graphqljava.domain.User;
import com.graphqljava.repositories.LinkRepository;
import com.graphqljava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Link> allLinks() {
        return linkRepository.findAll();
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
