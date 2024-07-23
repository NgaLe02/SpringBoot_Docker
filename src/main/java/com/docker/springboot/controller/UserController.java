package com.docker.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.springboot.model.User;
import com.docker.springboot.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("get/{id}")
	public User getHello(@PathVariable int id) {
		User user = userService.getUser(id);
		return user;
	}

	@GetMapping("getAll")
	public List<User> getAll() {
		List<User> user = userService.getAllUser();
		return user;
	}
	
	@PostMapping("insert")
	public int insert(@RequestBody User user) {
		int result = userService.saveUser(user);
		return result;
	}
}
