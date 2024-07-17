package com.docker.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.springboot.service.HelloService;

@RestController
@RequestMapping("")
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping("/hello")
	public String getHello() {
		String name = helloService.getName();
		return "Tui là " + name +  " nè";
	}
}
