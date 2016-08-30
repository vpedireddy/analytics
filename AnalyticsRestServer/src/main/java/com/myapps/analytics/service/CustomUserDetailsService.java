package com.myapps.analytics.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myapps.analytics.domain.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		 log.info("AnalyticsRestServer:[CustomUserDetailsService:loadUserByUsername]::i/p:::"+email);
		
         User user = userService.findUserByEmail(email);
                  
         if(user == null){
 			throw new UsernameNotFoundException("UserName "+email+" not found");
 		 }
         log.info("AnalyticsRestServer:[CustomUserDetailsService:loadUserByUsername]::i/p:::"+user);
         return user;
	}

}
