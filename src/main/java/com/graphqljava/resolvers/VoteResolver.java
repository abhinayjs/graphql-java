package com.graphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqljava.domain.Link;
import com.graphqljava.domain.User;
import com.graphqljava.domain.Vote;
import com.graphqljava.repositories.LinkRepository;
import com.graphqljava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VoteResolver implements GraphQLResolver<Vote> {
    @Autowired
    LinkRepository linkRepository;

    @Autowired
    UserRepository userRepository;

    public User user(Vote vote) {
        return userRepository.findById(vote.getUserId()).get();
    }

    public Link link(Vote vote) {
        return linkRepository.findById(vote.getLinkId()).get();
    }
}
