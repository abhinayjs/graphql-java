package com.graphqljava;

import com.graphqljava.domain.LinkRepository;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@SpringBootApplication
public class GraphQLJava {

    @Bean
    static MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(), "hackernews");
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphQLJava.class);
    }

}
