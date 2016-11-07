package com.aptmgmt.rest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.aptmgmt.entity.User;
import com.aptmgmt.services.UserDetailService;

@Component
public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

	private UserDetailService userService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = this.getAsHttpRequest(request);

		String accessToken = this.extractAuthTokenFromRequest(httpRequest);
		if (null != accessToken) {
			User user = this.userService.findUserByAccessToken(accessToken);
			if (null != user) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,
						user.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		chain.doFilter(request, response);
	}

	private HttpServletRequest getAsHttpRequest(ServletRequest request) {
		if (!(request instanceof HttpServletRequest)) {
			throw new RuntimeException("Expecting an HTTP request");
		}

		return (HttpServletRequest) request;
	}

	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
		/* Get token from header */
		String authToken = httpRequest.getHeader("X-Access-Token");

		/* If token not found get it from request parameter */
		if (authToken == null) {
			authToken = httpRequest.getParameter("token");
		}

		return authToken;
	}

	public void setUserService(UserDetailService userService) {
		this.userService = userService;
	}
}
