package com.docker.springboot.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.docker.springboot.dao.UserDAO;
import com.docker.springboot.exception.ResourceNotFoundException;
import com.docker.springboot.model.User;
import com.docker.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Override
	public int saveUser(User user) {
		int result = userDAO.insertUser(user);
		return result;
	}

	@Override
	public User getUser(int id) {
		final String key = "post_" + id;
		final ValueOperations<String, User> operations = redisTemplate.opsForValue();
		final boolean hasKey = redisTemplate.hasKey(key);

		if (hasKey) {
			System.out.println("Yes");
			final User user = operations.get(key);
			return user;
		}

		final Optional<User> user = Optional.ofNullable(userDAO.getUser(id));
		if (user.isPresent()) {
			operations.set(key, user.get(), 10, TimeUnit.SECONDS);
			return user.get();
		} else {
			throw new ResourceNotFoundException();
		}
//		User result = userDAO.getUser(id);
//		return result;
	}

	@Override
	public List<User> getAllUser() {
		List<User> result = userDAO.getAllUser();
		return result;
	}

}
