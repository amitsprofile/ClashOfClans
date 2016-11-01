package com.aptmgmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aptmgmt.dao.UserDAO;
import com.aptmgmt.model.User;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDAO userdao;

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = (User) userdao.findByUsername(username);
		return user;
	}

}