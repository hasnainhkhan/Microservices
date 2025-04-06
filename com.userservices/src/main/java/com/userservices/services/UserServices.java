package com.userservices.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userservices.entities.UserEntity;


public interface UserServices {

	UserEntity createUser(UserEntity uses);
	
	List<UserEntity> getAll();
}
