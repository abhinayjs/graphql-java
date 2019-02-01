package com.graphqljava.security;

import com.graphqljava.domain.ApiKey;
import com.graphqljava.repositories.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ApiKeyBasedAuthenticationManager implements AuthenticationManager {

    @Autowired
    ApiKeyRepository apiKeyRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        ApiKey apiKey = apiKeyRepository.findByKey(principal);
        if (apiKey != null) {
            return new GraphQLAuthenticationToken(apiKey);
        }
        throw new BadCredentialsException("The API key was not found or not the expected value.");
    }

    public static class GraphQLAuthenticationToken extends AbstractAuthenticationToken {

        ApiKey key;

        public GraphQLAuthenticationToken(ApiKey key) {
            super(Collections.singletonList(new SimpleGrantedAuthority(key.getRole())));
            this.key = key;
            this.setAuthenticated(true);
        }

        @Override
        public Object getCredentials() {
            return null;
        }

        @Override
        public Object getPrincipal() {
            return null;
        }
    }
}
