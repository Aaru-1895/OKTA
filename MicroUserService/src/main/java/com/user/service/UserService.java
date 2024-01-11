package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {
	
	
	public User saveUser(User u);
	
	public List<User> getAllUser();
	
	public User getUserById(int id);

}
