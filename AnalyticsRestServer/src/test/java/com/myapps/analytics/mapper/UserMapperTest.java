package com.myapps.analytics.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myapps.analytics.WebAppInitializer;
import com.myapps.analytics.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebAppInitializer.class)
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;

	//@Test
	public void findAllUsers() {
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}

    @Test
	public void findUserById() {
		//User user = userMapper.findUserById(1);
		//assertNotNull(user);
	}

	//@Test
	public void createUser() {
		User user = getUser();
		userMapper.insertUser(user);
		User newUser = userMapper.findUserById(user.getId());
		assertEquals("Sunil", newUser.getFirstName());
		assertEquals("syerra@gmail.com", newUser.getEmail());
	}
	
	private User getUser(){
		User u = new User();
		u.setAge(31);
		u.setEmail("syerra@osius.com");
		u.setFirstName("Sunil");
		u.setLastName("Yerra");
		u.setMobile("9347286840");
		u.setSex("Male");
		u.setUsername("syerra");
		u.setPassword("jisriram");
		u.setId(1500);
		return u;
	}
}
