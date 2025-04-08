package com.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hotel.payload.ApiResponse;

public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<ApiResponse>handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}

}
