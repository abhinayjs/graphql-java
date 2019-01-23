package com.graphqljava.errorhandlers;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvalidCredentialsException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public InvalidCredentialsException(String message) {
        super(message);
    }
    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
