package com.myapps.analytics.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapps.analytics.mongo.data.ProfileRepository;
import com.myapps.analytics.mongo.data.UserRepository;
import com.myapps.analytics.mongo.domain.Name;
import com.myapps.analytics.mongo.domain.Profile;
import com.myapps.analytics.mongo.domain.User;

//To kill tasks
//netstat -ano | find "8090"
//taskkill /F /PID 5364

@RestController
@RequestMapping(value = "/api/mongo/user")
public class UserMongoRestController {

	private static final Logger log = LoggerFactory.getLogger(UserMongoRestController.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
	public User getUserDetails(@PathVariable("userId") String userId) {
		return userRepository.findOne(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/createprofile/{empid}")
	public Profile createProfile(@PathVariable("empid") String empid){
		
		Profile profile = new Profile();
		profile.setId(empid);
		profile.setAge(30);
		Name name = new Name();
		name.setFname("Veera");
		name.setLname("Pedireddy");
		profile.setName(name );
		profile = profileRepository.save(profile);
		return profile;
	}

}
