package com.userservices.services;

import java.util.List;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.userservices.entities.UserEntity;
import com.userservices.repository.UserServiceRepo;

@Component
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserServiceRepo userServiceRepo;

	@Override
	public UserEntity createUser(UserEntity users) {
		return userServiceRepo.save(users);
		
	}

	@Override
	public List<UserEntity> getAll() {
		UserServiceRepo userServiceRepo2 = userServiceRepo;
		return userServiceRepo2.findAll();
	}
	
	
}
