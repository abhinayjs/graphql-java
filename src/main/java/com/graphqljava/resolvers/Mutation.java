package com.graphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqljava.domain.*;
import com.graphqljava.errorhandlers.InvalidCredentialsException;
import com.graphqljava.repositories.LinkRepository;
import com.graphqljava.repositories.UserRepository;
import com.graphqljava.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    LinkRepository linkRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VoteRepository voteRepository;

    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        return linkRepository.insert(newLink);
    }

    public User createUser(String name, AuthData auth) {
        User newUser = new User(name, auth.getEmail(), auth.getPassword());
        return userRepository.insert(newUser);
    }

    public SigninPayload signinUser(AuthData authData) {
        User user = userRepository.findByEmail(authData.getEmail());
        if (user.getPassword().equals(authData.getPassword())){
            return new SigninPayload(user.getId(), user);
        }
        throw new InvalidCredentialsException("Invalid Credentials");
    }

    public Vote createVote (String linkId, String userId) {
        return voteRepository.insert(new Vote(new Date(), userId, linkId));
    }
}
