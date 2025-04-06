package com.userservices.exception;

public class ResourceNotFoundException  extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("Resourse not found on server");
	}

}
