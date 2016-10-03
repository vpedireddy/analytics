package com.myapps.analytics.service;

import java.util.List;

import com.myapps.analytics.domain.User;


public interface UserService {
	
	/*public void setUserMapper(UserMapper userMapper);
	
	public UserMapper getUserMapper();*/
	
	public User findUserById(int id);
	
	public User findUserByEmail(String email);
	
	public User saveUser(User user);
	
	public List<User> findAllUsers();

	public User updateUser(User user);

	public User getAuthenticatedUser();

}
