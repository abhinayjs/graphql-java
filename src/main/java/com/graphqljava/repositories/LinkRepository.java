package com.graphqljava.repositories;

import com.graphqljava.domain.Link;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public interface LinkRepository extends MongoRepository<Link, String> {
}

