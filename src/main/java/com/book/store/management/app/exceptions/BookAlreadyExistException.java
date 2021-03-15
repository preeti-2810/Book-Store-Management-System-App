package com.book.store.management.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class BookAlreadyExistException  extends RuntimeException {

	public BookAlreadyExistException() {
		super();
	}

	public BookAlreadyExistException(String message) {
		super(message);
	}

}
