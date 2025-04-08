package com.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.HotelEntity;
import com.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	// create Hotels
	@PostMapping
	public ResponseEntity<HotelEntity> createHotel(@RequestBody HotelEntity hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	//get all details of hotel
	@GetMapping("/{id}")
	public ResponseEntity<HotelEntity>getById(@RequestParam String id){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getById(id));
	}
	
}
