package com.graphqljava.repositories;

import com.graphqljava.domain.Link;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkRepository extends MongoRepository<Link, String> {
}

