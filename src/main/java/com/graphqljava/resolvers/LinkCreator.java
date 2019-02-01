package com.graphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqljava.domain.AuthData;
import com.graphqljava.domain.Link;
import com.graphqljava.domain.SigninPayload;
import com.graphqljava.domain.User;
import com.graphqljava.errorhandlers.InvalidCredentialsException;
import com.graphqljava.repositories.LinkRepository;
import com.graphqljava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkCreator implements GraphQLMutationResolver {

    @Autowired
    LinkRepository linkRepository;

    @Autowired
    UserRepository userRepository;

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
}
