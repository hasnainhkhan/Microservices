package com.userservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.userservices.entities.UserEntity;
import com.userservices.exception.ResourceNotFoundException;
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
		return userServiceRepo.findAll();
	}
	
	@Override 
	public UserEntity findById(String id) {
	    return userServiceRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Resource not found on server: " + id));
	}
	
	@Override
	public void deleteAll(String id) {
	    UserEntity user = userServiceRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	    
	    userServiceRepo.deleteById(id);
	}
	
	@Override
	public UserEntity updateById(UserEntity user) {
		return userServiceRepo.save(user);
	}


}
