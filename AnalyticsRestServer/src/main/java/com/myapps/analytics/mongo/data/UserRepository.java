package com.myapps.analytics.mongo.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myapps.analytics.mongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
