package com.myapps.analytics.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.myapps.analytics.domain.User;
import com.myapps.analytics.mapper.UserMapper;
import com.myapps.analytics.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserMapper userMapper;
	
	
	@Before
    public void setUp() {
		//userMapper = mock(UserMapper.class); // this is not required if Mock annotation used.
		//userservice.setUserMapper(userMapper);
        //when(this.userservice.getUserMapper()).thenReturn(userMapper);  // Wrong bcoz when requires metho call only on MOCK object. Here, Service is not a MOCK object.
		//when(this.userMapper.findAllUsers()).thenReturn(getUserList()); // right syntax
		//given(this.userservice.getUserMapper()).willReturn(userMapper); // Wrong syntax
		given(this.userMapper.findAllUsers()).willReturn(getUserList());  // right syntax
    }

	@Test
	public void findAllUsers() {
		List<User> users = userService.findAllUsers();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
		assertTrue(users.get(0).getId()==100);
		assertTrue(users.get(1).getId()==101);
		assertTrue(users.get(2).getId()==102);
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
		user.setFirstName("fn" + i);
		user.setLastName("ln" + i);
		return user;
	}

	@Test
	public void findUserById() {
		User u = getUser(100);
		given(userMapper.findUserById(100)).willReturn(u);
		User user = userMapper.findUserById(100);
		assertNotNull(user);
		assertTrue(user.getId() == 100);
	}

	@Test
	public void createUser() {
		User user = getUser();
		Mockito.doNothing().when(userMapper).insertUser(user);
		given(userMapper.findUserById(user.getId())).willReturn(user);
		userService.saveUser(user);
		User newUser = userService.findUserById(user.getId());
		assertEquals("Sunil", newUser.getFirstName());
		assertEquals("syerra@osius.com", newUser.getEmail());
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
