package com.userservices.services;

import java.util.List;


import com.userservices.entities.UserEntity;


public interface UserServices {
	
	//create new user
	UserEntity createUser(UserEntity uses);
	//get all user info
	List<UserEntity> getAll();
	//get single user
	UserEntity findById(String id);
	//delete single user
	void deleteAll(String id);
	
	//update user info
	UserEntity updateById(UserEntity user);
	
	
}
