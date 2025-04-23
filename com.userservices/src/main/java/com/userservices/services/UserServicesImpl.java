package com.userservices.services;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

import com.userservices.entities.Hotel;
import com.userservices.entities.Ratings;
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
	    List<UserEntity> users = userServiceRepo.findAll();

	    for (UserEntity user : users) {
	        // Assuming user has a getId() method
	        String userId = user.getId(); 
	        
	        // Fetch ratings for the user
	        List<Ratings> ratings = restTemplate.getForObject(
	            "http://localhost:8083/ratings/hotels/" + userId,
	            List.class
	        );
	        
	        logger.info("Ratings for user {}: {}", userId, ratings);

	        // Assuming UserEntity has setRatings(List<Object>) method
	        user.setRatings(ratings);
	    }

	    return users;
	}
	
	@Override 
	public UserEntity findById(String id) {
	    
	    // 1. Get ratings by user ID
	    ArrayList<Ratings> ratingsList = restTemplate
	        .getForObject("http://localhost:8083/ratings/hotels/" + id, ArrayList.class);
	    logger.info("{}", ratingsList);

	    // 2. Get user info
	    UserEntity user = userServiceRepo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Resource not found on server: " + id));

	    // 3. For each rating, get the hotel and set it
	    List<Ratings> enrichedRatings = ratingsList.stream().map(rating -> {
	        String hotelId = rating.getHotelId(); // Assuming Ratings class has getHotelId()

	        ResponseEntity<Hotel> hotelResponse = restTemplate
	            .getForEntity("http://localhost:8082/hotels/" + hotelId, Hotel.class);

	        Hotel hotel = hotelResponse.getBody();
	        rating.setHotel(hotel); // Assuming Ratings class has setHotel()

	        return rating;
	    }).collect(Collectors.toList());

	    user.setRatings(enrichedRatings);
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
