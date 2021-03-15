package com.book.store.management.app.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException() {
		
		super();
	}
	
	public CustomerNotFoundException(String message) {
		
		super(message);
	}

}
