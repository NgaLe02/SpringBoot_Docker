package com.docker.springboot.service;

import java.util.List;

import com.docker.springboot.model.User;

public interface UserService {
	int saveUser(User user);
	User getUser(int id);
	List<User> getAllUser();

}
