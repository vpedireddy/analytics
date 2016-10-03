package com.myapps.analytics.mongo.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myapps.analytics.mongo.domain.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String> {

}
