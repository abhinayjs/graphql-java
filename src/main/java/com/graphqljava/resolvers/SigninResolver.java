package com.graphqljava.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqljava.domain.SigninPayload;
import com.graphqljava.domain.User;

public class SigninResolver implements GraphQLResolver<SigninPayload> {

    public User user(SigninPayload payload) {
        return payload.getUser();
    }
}
