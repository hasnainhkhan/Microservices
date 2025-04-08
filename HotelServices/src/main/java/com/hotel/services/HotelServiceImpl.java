package com.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.HotelEntity;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repositories.HotelRepo;


public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public HotelEntity create(HotelEntity hotelEntity) {
		String uId =  UUID.randomUUID().toString();
		hotelEntity.setId(uId);
		return hotelRepo.save(hotelEntity);
	}

	@Override
	public List<HotelEntity> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public HotelEntity getById(String id) {
		
		return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Record Not Found"));
	}

}
