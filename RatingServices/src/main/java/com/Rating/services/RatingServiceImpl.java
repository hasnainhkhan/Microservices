package com.Rating.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rating.entities.RatingEntity;
import com.Rating.repositories.RatingsRepo;

@Service
public class RatingServiceImpl implements RatingServices{
	
	@Autowired
	private RatingsRepo ratingsRepo;

	@Override
	public RatingEntity create(RatingEntity rating) {
		String uuid = UUID.randomUUID().toString();
		rating.setRatingId(uuid);
		return ratingsRepo.save(rating);
	}

	@Override
	public List<RatingEntity> getAll() {
		return ratingsRepo.findAll();
	}

	@Override
	public List<RatingEntity> getByUserId(String userId) {
		return ratingsRepo.findByUserId(userId);
	}

	@Override
	public List<RatingEntity> getByHotelId(String hotelId) {
		return ratingsRepo.findByHotelId(hotelId);
	}

}
