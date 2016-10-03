package com.myapps.analytics.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myapps.analytics.mongo.data.ProfileRepository;
import com.myapps.analytics.mongo.domain.Name;
import com.myapps.analytics.mongo.domain.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMongoRestControllerTest {

	@InjectMocks
	private UserMongoRestController userMongoRestController;

	@Mock
	private ProfileRepository profileRepository;

	@Before
	public void setup() {

	}

	@Test
	public void createProfile() {
		
		Profile value = getProfile();
		given(profileRepository.save(any(Profile.class))).willReturn(value );
		Profile profile = userMongoRestController.createProfile("100");
		assertTrue(profile.getName().getFname().equals("veera"));
	}

	private Profile getProfile() {
		Profile p = new Profile();
		p.setId("100");
		p.setAge(30);
		Name name = new Name();
		name.setFname("veera");
		name.setLname("pedireddy");
		p.setName(name);
		return p;
	}

}
