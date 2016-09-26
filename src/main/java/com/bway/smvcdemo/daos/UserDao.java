package com.bway.smvcdemo.daos;

import com.bway.smvcdemo.models.User;

public interface UserDao {
	
	public User getUser(Long id);
	// Using Jdbc Template
	public boolean validateUser(User user);
}
