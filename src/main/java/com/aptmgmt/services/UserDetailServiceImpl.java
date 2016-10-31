package com.aptmgmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aptmgmt.dao.UsersDAO;
import com.aptmgmt.model.Users;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UsersDAO userdao;

	public void setUserdao(UsersDAO userdao) {
		this.userdao = userdao;
	}

	public Users loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = (Users) userdao.findByUsername(username);
		return user;
	}

}