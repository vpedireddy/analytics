package com.myapps.analytics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.myapps.analytics.domain.User;


@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("userInfo", authUser);
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		
	}

}