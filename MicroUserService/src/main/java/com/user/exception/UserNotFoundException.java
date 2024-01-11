package com.user.exception;

public class UserNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
		UserNotFoundException(){
			super("User Not Found !!");
			
		}
		
		public UserNotFoundException(String response){
			super(response);
			
		}

}
