package com.docker.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.docker.springboot.model.User;

@Mapper
public interface UserDAO {
		
	int insertUser(User user);
	User getUser(int id);
	List<User> getAllUser();
}
