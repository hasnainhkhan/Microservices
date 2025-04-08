package com.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter
@Entity @Table(name = "Hotel")
public class HotelEntity {
	
	@Id
	private String id;
	private String name;
	private String location;
	private String about;
}
