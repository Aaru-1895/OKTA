package com.hotel.exception;

public class ResourceNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	ResourceNotFoundException(){
		super("Resource Not Found For This Id");
	}
	
	public ResourceNotFoundException(String message){
		super(message);
	}

}
