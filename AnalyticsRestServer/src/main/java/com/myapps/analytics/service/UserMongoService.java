package com.myapps.analytics.service;

import java.util.List;

import com.myapps.analytics.mongo.domain.User;

public interface UserMongoService {

	public User findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);
}
