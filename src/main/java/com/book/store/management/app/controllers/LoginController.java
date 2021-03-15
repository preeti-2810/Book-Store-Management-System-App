package com.book.store.management.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.book.store.management.app.entities.User;
import com.book.store.management.app.services.LoginService;

public class LoginController {
	
@Autowired
LoginService loginService;
Logger logger = LoggerFactory.getLogger(LoginController.class);
@PostMapping("/users")
@ResponseStatus(code = HttpStatus.CREATED)
public User addUser(@RequestBody User user) {
	logger.info("Adding a user..");
	return loginService.addUser(user);
}

@DeleteMapping("/users")
@ResponseStatus(code = HttpStatus.OK)
public User removeUser(@RequestBody User user) {
	
	logger.info("Deleting a user...");
	return loginService.removeUser(user);
}

@GetMapping("/users")
@ResponseStatus(code = HttpStatus.FOUND)
public User validateUser(@RequestBody User user) {

	logger.info("Validating a user...");
	return loginService.validateUser(user);
	

}
}
