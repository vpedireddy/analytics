package com.myapps.analytics.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapps.analytics.domain.User;
import com.myapps.analytics.service.UserService;

//To kill tasks
//netstat -ano | find "8090"
//taskkill /F /PID 5364

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {
	
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE})
	public User registerUser(@RequestBody User user,HttpSession session){
		log.info("AnalyticsRestServer:[UserRestController:registerUser]:::::");
		
		User u = userService.saveUser(user);
		return u;
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE})
	public User updateUser(@RequestBody User user,HttpSession session){
		log.info("AnalyticsRestServer:[UserRestController:updateUser]:::::"+user);
		
		User u = userService.updateUser(user);
		return u;
	}
	
	/*
	 * Example
	 * http://localhost:8090/api/user/fetchuser?id=1197
	 */
	@RequestMapping(value = "/fetchuser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User findUserWithRequestParam(@RequestParam("id") int id){
		
		log.info("AnalyticsRestServer:[UserRestController:findUserWithRequestParam]::i/p:::"+id);
			
		User u = userService.findUserById(id);
		
		log.info("AnalyticsRestServer:[UserRestController:findUserWithRequestParam]::o/p:::"+u);
		
		return u;
	}
	
	/*
	 * Example
	 * http://localhost:8090/api/user/fetchusers
	 */
	@RequestMapping(value = "/fetchusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findUsers(){
		
		log.info("AnalyticsRestServer:[UserRestController:findUsers]::i/p:::");
			
		List<User> users = userService.findAllUsers();
		
		return users;
	}
	
	
	/*
	 * Example
	 * http://localhost:8090/api/user/getuser/1197
	 */
	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User findUserWithPathVariable(@PathVariable("id") int id){
		
		log.info("AnalyticsRestServer:[UserRestController:findUserWithPathVariable]::i/p:::"+id);
				
		User u = userService.findUserById(id);
		
		log.info("AnalyticsRestServer:[UserRestController:findUserWithPathVariable]::o/p:::"+u);
		
		return u;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE})
	public User login(@RequestBody User user)
			throws IOException {
		log.info("AnalyticsRestServer:[UserRestController:login]"+user);
		user = userService.getAuthenticatedUser(); 
		log.info("AnalyticsRestServer:[UserRestController:login]"+user);
		return user;
	}
	
	
	
	@RequestMapping(value = "/getUserMsg", method = RequestMethod.GET)
	public String getUserMessage(){
		
		log.info("AnalyticsRestServer:[UserRestController:getUserMessage]::i/p:::");
		return "Hi Veeru..";
	}

}
