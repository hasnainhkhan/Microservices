package com.userservices.controller;

import org.springframework.web.bind.annotation.RestController;

import com.userservices.entities.UserEntity;
import com.userservices.services.UserServices;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
		UserEntity user1 = userServices.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping
	public List<UserEntity> getAll() {
		return userServices.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable String id) {
		
		UserEntity user =  userServices.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
	    userServices.deleteAll(id);
	    return ResponseEntity.ok("User deleted successfully with ID: " + id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable String id, @RequestBody UserEntity userEntity) {
	    userEntity.setId(id);  // Enforce ID from path
	    UserEntity updated = userServices.updateById(userEntity);
	    return ResponseEntity.ok(updated);
	}
}
