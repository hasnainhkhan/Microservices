package com.userservices.services;

import java.util.List;


import com.userservices.entities.UserEntity;


public interface UserServices {

	UserEntity createUser(UserEntity uses);
	
	List<UserEntity> getAll();

	UserEntity findById(String id);
	
	
}
