package com.graphqljava.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ApiKeyBasedAuthenticationManager apiKeyBasedAuthenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ApiKeyAuthenticationFilter authFilter = new ApiKeyAuthenticationFilter();
        authFilter.setAuthenticationManager(apiKeyBasedAuthenticationManager);
        http.csrf().disable()
                .addFilter(authFilter)
                .authorizeRequests()
                // needs to match against endpoint query with and without trailing forward slash
                // as the graphql servlet accepts queries to both and spring security is dumb
                .antMatchers("/graphql", "/graphql/")
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/graphiql").permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
