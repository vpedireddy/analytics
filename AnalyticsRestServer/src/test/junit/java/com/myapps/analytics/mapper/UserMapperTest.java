package com.myapps.analytics.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.myapps.analytics.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserMapperTest {

	
	@MockBean
	private UserMapper userMapper;

	@Test
	public void findAllUsers() {
		given(this.userMapper.findAllUsers()).willReturn(getUserList());
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}

	private List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		list.add(getUser(100));
		list.add(getUser(101));
		list.add(getUser(102));
		return list;
	}

	private User getUser(int i) {
		User user = new User();
		user.setId(i);
		user.setFirstName("fn"+i);
		user.setLastName("ln"+i);
		return user;
	}

	@Test
	public void findUserById() {
		User user = userMapper.findUserById(1);
		assertNotNull(user);
	}

	@Test
	public void createUser() {
		User user = getUser();
		userMapper.insertUser(user);
		User newUser = userMapper.findUserById(user.getId());
		assertEquals("Sunil", newUser.getFirstName());
		assertEquals("syerra@gmail.com", newUser.getEmail());
	}

	private User getUser() {
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
