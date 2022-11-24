package com.digitalBooks.service;


import java.util.Optional;

import com.digitalBooks.components.User;

public interface UserService {
	
	public User getUser(int userId);
	public User createUser(User user);
	public Optional<User> getUserByUserNameAndPassword(String userName, String password);

}
