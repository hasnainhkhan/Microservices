package com.userservices.controller;

import org.springframework.web.bind.annotation.RestController;

import com.userservices.entities.UserEntity;
import com.userservices.services.UserServices;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController 
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity user) {
		UserEntity user1 = userServices.createUser(user);
		return user1;
	}
	
}
