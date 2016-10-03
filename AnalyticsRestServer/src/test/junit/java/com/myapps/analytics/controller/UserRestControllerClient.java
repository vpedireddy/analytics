package com.myapps.analytics.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myapps.analytics.WebAppInitializer;
import com.myapps.analytics.domain.User;

/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebAppInitializer.class)
@WebIntegrationTest("server.port:0")*/
public class UserRestControllerClient {

	private RestTemplate restTemplate = new TestRestTemplate();
	
	@Before
    public void setUp() {
	}
	
	@Test
	public void testRegisterUser() throws JsonProcessingException{
		
		ResponseEntity<User> result =null;
		User user = getUser();
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<User> httpEntity =  new HttpEntity<User>(user, requestHeaders);

		try {
            result = restTemplate.exchange("http://localhost:8090/api/user/registerUser", HttpMethod.POST, httpEntity, User.class);
        } catch(Exception e) {
            e.printStackTrace();
        }

		assertNotNull(result);
		
	}
	
	@Test
	public void testLogin() throws JsonProcessingException{
		
		ResponseEntity<User> result =null;
		User user = getUserForLogin();
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<User> httpEntity =  new HttpEntity<User>(user, requestHeaders);

		try {
            result = restTemplate.exchange("http://localhost:8090/api/user/login", HttpMethod.POST, httpEntity, User.class);
        } catch(Exception e) {
            e.printStackTrace();
        }

		assertNotNull(result);
		
	}
	
	@Test
	public void testFindUserWithRequestParam() throws JsonProcessingException{
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<User> result =null;
		String url = "http://localhost:8090/api/user/fetchuser";
		int id =1197;
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("id", id);

		HttpEntity httpEntity =  new HttpEntity(requestHeaders);
		try {
			result = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, httpEntity, User.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
		assertNotNull(result);
		
	}
	
	
	
	@Test
	public void testFindUserWithPathVariable() throws JsonProcessingException{
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		int id =1197;
		ResponseEntity<User> result =null;
		String url = "http://localhost:8090/api/user/getuser/"+id;
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

		HttpEntity httpEntity =  new HttpEntity(requestHeaders);
		try {
			result = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, httpEntity, User.class);
        } catch(Exception e) {
            e.printStackTrace();
        }

		assertNotNull(result);
		
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
		u.setPassword("123");
		u.setId(1500);
		return u;
	}
	
	private User getUserForLogin(){
		User u = new User();
		u.setEmail("veerup.rc@gmail.com");
		u.setPassword("123");
		return u;
	}
}
