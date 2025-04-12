package com.userservices.services;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;
import com.userservices.entities.UserEntity;
import com.userservices.exception.ResourceNotFoundException;
import com.userservices.repository.UserServiceRepo;



@Component 
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserServiceRepo userServiceRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	// Logger
	private org.slf4j.Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

	@Override 
	public UserEntity createUser(UserEntity users) {
		String randomUID = UUID.randomUUID().toString();
		users.setId(randomUID);
		return userServiceRepo.save(users);
		
	}

	@Override
	public List<UserEntity> getAll() {
		return userServiceRepo.findAll();
	}
	
	@Override 
	public UserEntity findById(String id) {
		ArrayList forObject =  restTemplate
		.getForObject("http://localhost:8083/ratings/hotels/"+id
				,ArrayList.class);
		logger.info("{}",forObject);
	    UserEntity user =  userServiceRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Resource not found on server: " + id));
	    user.setRatings(forObject);
	    return user;
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
