package com.Rating.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Entity
@Table(name="Ratings")
public class RatingEntity {
	
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int ratings;
	private String feedBack;
}
