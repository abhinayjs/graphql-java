package com.graphqljava;

import com.graphqljava.errorhandlers.ApplicationErrorAdapter;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class GraphQLJava {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLJava.class);
    }

    @Bean
    public GraphQLErrorHandler errorHandler(){
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(ApplicationErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> errorsList = new ArrayList<>();
                errorsList.addAll(clientErrors);
                errorsList.addAll(serverErrors);
                return errorsList;
            }

            protected boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }

}
