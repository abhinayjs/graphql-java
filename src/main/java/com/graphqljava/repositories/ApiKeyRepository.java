package com.graphqljava.repositories;

import com.graphqljava.domain.ApiKey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApiKeyRepository extends MongoRepository<ApiKey, String> {

    ApiKey findByKey(String key);
}
