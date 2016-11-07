package com.aptmgmt.model;

public class AccessToken {

	private final String token;
	private final User user;

	public AccessToken(String token, User user) {
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return this.token;
	}

	public User getUser() {
		return user;
	}
}
