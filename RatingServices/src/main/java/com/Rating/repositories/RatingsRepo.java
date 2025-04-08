package com.Rating.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rating.entities.RatingEntity;

public interface RatingsRepo extends JpaRepository<RatingEntity, String>{
	
	List<RatingEntity> findByUserId(String userId);
	List<RatingEntity> findByHotelId(String hotelId);

}
