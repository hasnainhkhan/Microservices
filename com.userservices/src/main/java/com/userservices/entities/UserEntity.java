package com.userservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UserInfo")
public class UserEntity {
	
	@Id
	@Column( name = "ID")
	private String id;
	
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name= "About")
	private String about;
}
