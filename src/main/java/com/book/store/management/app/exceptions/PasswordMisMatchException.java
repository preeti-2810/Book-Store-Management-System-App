package com.book.store.management.app.exceptions;

public class PasswordMisMatchException extends RuntimeException{

	public PasswordMisMatchException() {
		
		super();
	}
	
	public PasswordMisMatchException(String message) {
		
		super(message);
	}
}
