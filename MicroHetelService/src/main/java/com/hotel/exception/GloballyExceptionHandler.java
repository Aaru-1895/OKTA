package com.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloballyExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionGenerated(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse res=	ApiResponse.builder().message(message).status(true).response(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(res,HttpStatus.NOT_FOUND);
		
	}

}
