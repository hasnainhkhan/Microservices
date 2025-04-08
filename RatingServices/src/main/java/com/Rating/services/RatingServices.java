package com.Rating.services;

import java.util.List;


import com.Rating.entities.RatingEntity;


public interface RatingServices {
	
	//create rating
	RatingEntity create(RatingEntity rating);
	
	//get all rating
	List<RatingEntity>getAll();
	
	//get rating byUserId
	
	List<RatingEntity>getByUserId(String userId);
	
	//get rating byHotelId;
	
	List<RatingEntity>getByHotelId(String hotelId);
}
