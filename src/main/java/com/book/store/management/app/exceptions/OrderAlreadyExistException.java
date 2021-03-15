package com.book.store.management.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class OrderAlreadyExistException extends RuntimeException {

	public OrderAlreadyExistException() {
		
		super();
	}
	
	public OrderAlreadyExistException(String message) {
		
		super(message);
	}
}
