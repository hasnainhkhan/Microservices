package com.hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.entities.HotelEntity;

@Service
public interface HotelService {
	
	//create hotel
	
	HotelEntity create(HotelEntity hotelEntity);
	// get all hotel
	
	List<HotelEntity> getAll();
	// get by id
	
	HotelEntity getById(String Id);
}
