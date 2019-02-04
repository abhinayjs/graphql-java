package com.graphqljava.repositories;

import com.graphqljava.domain.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoteRepository extends MongoRepository<Vote, String> {
}
