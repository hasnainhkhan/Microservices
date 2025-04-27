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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
	        String userId = user.getId();

	        try {
	            // Fetch ratings properly
	            ResponseEntity<List<Ratings>> responseEntity = restTemplate.exchange(
	                    "http://RATING-SERVICE/ratings/hotels/" + userId,
	                    HttpMethod.GET,
	                    null,
	                    new ParameterizedTypeReference<List<Ratings>>() {}
	            );
	            List<Ratings> ratingsList = responseEntity.getBody();

	            logger.info("Ratings for user {}: {}", userId, ratingsList);

	            if (ratingsList != null) {
	                // Enrich each rating with hotel details
	                List<Ratings> enrichedRatings = ratingsList.stream().map(rating -> {
	                    Hotel hotel = null;
	                    try {
	                        ResponseEntity<Hotel> hotelResponse = restTemplate.getForEntity(
	                                "http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
	                                Hotel.class
	                        );
	                        hotel = hotelResponse.getBody();
	                    } catch (Exception ex) {
	                        logger.error("Failed to fetch hotel with ID: {}", rating.getHotelId(), ex);
	                    }
	                    rating.setHotel(hotel);
	                    return rating;
	                }).collect(Collectors.toList());

	                user.setRatings(enrichedRatings);
	            }

	        } catch (Exception ex) {
	            logger.error("Failed to fetch ratings for userId: {}", userId, ex);
	        }
	    }

	    return users;
	}

	
	@Override
	public UserEntity findById(String id) {
	    // 1. Fetch user details
	    UserEntity user = userServiceRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

	    // 2. Fetch ratings for user (properly with type)
	    ResponseEntity<List<Ratings>> responseEntity = restTemplate.exchange(
	            "http://RATING-SERVICE/ratings/hotels/" + id,
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<Ratings>>() {}
	    );
	    List<Ratings> ratingsList = responseEntity.getBody();
	    
	    logger.info("User Ratings: {}", ratingsList);

	    if (ratingsList != null) {
	        // 3. For each rating, fetch hotel details
	        List<Ratings> enrichedRatings = ratingsList.stream().map(rating -> {
	            Hotel hotel = null;
	            try {
	                ResponseEntity<Hotel> hotelResponse = restTemplate.getForEntity(
	                        "http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
	                        Hotel.class
	                );
	                hotel = hotelResponse.getBody();
	            } catch (Exception ex) {
	                logger.error("Failed to fetch hotel with ID: {}", rating.getHotelId(), ex);
	            }
	            rating.setHotel(hotel);
	            return rating;
	        }).collect(Collectors.toList());

	        user.setRatings(enrichedRatings);
	    }
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
