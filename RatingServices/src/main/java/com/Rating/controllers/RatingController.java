package com.Rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Rating.entities.RatingEntity;
import com.Rating.services.RatingServices;

@RestController @RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingServices ratingServices;
	
	@PostMapping
	public ResponseEntity<RatingEntity> createRatings(@RequestBody RatingEntity ratings) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.create(ratings));
	}
	//this handler search by UserID	
	@GetMapping("/hotels/{id}")
	public ResponseEntity<List<RatingEntity>>getRatingsById(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK).body(ratingServices.getByUserId(id));
	}
	
	// get all data handler
	
	@GetMapping
	public ResponseEntity<List<RatingEntity>>getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(ratingServices.getAll());
	}

}
