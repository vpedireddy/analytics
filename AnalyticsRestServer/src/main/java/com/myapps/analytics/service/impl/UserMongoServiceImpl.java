package com.myapps.analytics.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myapps.analytics.mongo.data.UserRepository;
import com.myapps.analytics.mongo.domain.User;
import com.myapps.analytics.service.UserMongoService;


@Service
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserMongoServiceImpl implements UserMongoService {

	private static final Logger log = LoggerFactory.getLogger(UserMongoServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByFirstName(String firstName) {
		log.info("AnalyticsRestServer:[UserMongoServiceImpl:findByFirstName]:::::");

		User u = userRepository.findOne(firstName);
		return u;
	}

	@Override
	public List<User> findByLastName(String lastName) {
		log.info("AnalyticsRestServer:[UserMongoServiceImpl:findByFirstName]:::::");

		List<User> list = userRepository.findAll();
		return list;
	}

	

}
