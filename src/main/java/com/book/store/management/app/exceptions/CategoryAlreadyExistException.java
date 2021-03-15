package com.book.store.management.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistException extends RuntimeException {

	public CategoryAlreadyExistException() {
		
		super();
	}
	
	public CategoryAlreadyExistException(String message) {
		
		super(message);
	}
}
