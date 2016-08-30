package com.myapps.analytics.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myapps.analytics.domain.User;
import com.myapps.analytics.mapper.UserMapper;
import com.myapps.analytics.service.UserService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	@Lazy
	private UserMapper userMapper;

	@Override
	public User findUserById(int id) {
		log.info("AnalyticsRestServer:[UserServiceImpl:findUserById]:::::");

		User u = userMapper.findUserById(id);
		return u;
	}

	@Override
	public User findUserByEmail(String email) {
		log.info("AnalyticsRestServer:[UserServiceImpl:findUserByEmail]:::::");

		User u = userMapper.findUserByEmail(email);
		return u;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public User saveUser(User user) {

		log.info("AnalyticsRestServer:[UserServiceImpl:saveUser]:::::");

		userMapper.insertUser(user);

		return user;
	}

	@Override
	public List<User> findAllUsers() {
		log.info("AnalyticsRestServer:[UserServiceImpl:findAllUsers]:::::");

		List<User> userList = userMapper.findAllUsers();
		return userList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public User updateUser(User user) {
		log.info("AnalyticsRestServer:[UserServiceImpl:updateUser]:::::");

		userMapper.updateUser(user);

		return user;
	}

	@Override
	public User getAuthenticatedUser() {
		log.info("AnalyticsRestServer:[UserServiceImpl:getAuthenticatedUser]:::::");
		
		User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return u;
	}
}
