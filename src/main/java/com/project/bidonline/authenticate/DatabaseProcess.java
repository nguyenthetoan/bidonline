package com.project.bidonline.authenticate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.bidonline.dao.UserDAO;
import com.project.bidonline.entity.User;

public class DatabaseProcess implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDAO.findUser(username);
		System.out.println("User: "+user);
		if (user == null) {
			throw new UsernameNotFoundException("Wrong user");
		}
		LoggedUser loggedUser = new LoggedUser();
		loggedUser.setUser(user);
		
		return loggedUser;
	}
	
}
