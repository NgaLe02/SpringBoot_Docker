package com.docker.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.springboot.dao.HelloDAO;
import com.docker.springboot.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService{
	
	@Autowired
	private HelloDAO helloDAO;
	@Override
	public String getName() {
		String name = helloDAO.getName();
		return name;
	}

}
