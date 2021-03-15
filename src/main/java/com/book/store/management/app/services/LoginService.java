package com.book.store.management.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.management.app.entities.User;
import com.book.store.management.app.exceptions.PasswordMisMatchException;
import com.book.store.management.app.exceptions.UserNotFoundException;
import com.book.store.management.app.exceptions.UserAlreadyExistException;
import com.book.store.management.app.repo.ILoginRepository;
import com.book.store.management.app.serviceInterface.ILoginService;



@Service
public class LoginService implements ILoginService {
	
	@Autowired
	ILoginRepository loginRepository;

	@Override
	public User addUser(User user) {

		User userObj = loginRepository.findByEmail(user.getEmail());
		
		if(userObj == null) {
		
			loginRepository.save(user);
			
		}
		
		else
			throw new UserAlreadyExistException("User with the email " + user.getEmail() + " already exist");
		
		return user;
	}

	@Override
	public User removeUser(User user) {
		
		User userObj = loginRepository.findByEmail(user.getEmail());
		
		if(userObj == null) 
			throw new UserNotFoundException("User with the email " + user.getEmail() + " not found");
		
		else
			loginRepository.delete(userObj);
			
		return userObj;
	}

	@Override
	public User validateUser(User user) {
		
		User userObj = loginRepository.findByEmail(user.getEmail());
		
		if(userObj == null) 
			throw new UserNotFoundException("User with the email " + user.getEmail() + " not found");
		
		else {
			
			if(userObj.getPassword().equals(user.getPassword()))
				return userObj;
			else
				throw new PasswordMisMatchException("Password is wrong");
		}
		

	}

}
