package com.project.bidonline.dao;

import com.project.bidonline.entity.User;

public interface UserDAO {
	public void saveAccount(User user);
	public void updateUser(User user);
	public User findUser(String username);
}
