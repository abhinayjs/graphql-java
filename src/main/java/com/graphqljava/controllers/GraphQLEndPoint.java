package com.graphqljava.controllers;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndPoint extends SimpleGraphQLServlet {

    public GraphQLEndPoint() {
        super(SchemaParser.newParser()
                .file("schema.graphqls")
                .build()
                .makeExecutableSchema());
    }
}
