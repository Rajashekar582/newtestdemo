package com.newtestdemo.demo.repository;

import com.newtestdemo.demo.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {}
