package com.myapps.analytics.client;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.myapps.analytics.domain.User;

public class UserRestClient {
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String args[]){
		
		ResponseEntity<User> result =null;
		User user = getUserForLogin();
		
		String plainCreds = "syerra@gmail.com:123";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Authorization", "Basic " + base64Creds);
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		
		HttpEntity<User> httpEntity =  new HttpEntity<User>(user, requestHeaders);

		try {
            result = restTemplate.exchange("http://localhost:8090/api/user/login", HttpMethod.POST, httpEntity, User.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
		
		User u = result.getBody();
		System.out.println("RESULT->"+u);
				
	}
	
	private static User getUserForLogin(){
		User u = new User();
		u.setEmail("syera@osius.com");
		u.setPassword("123");
		return u;
	}


}
