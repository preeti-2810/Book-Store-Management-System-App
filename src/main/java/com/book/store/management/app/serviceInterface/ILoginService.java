package com.book.store.management.app.serviceInterface;

import com.book.store.management.app.entities.User;

public interface ILoginService {

	public User addUser(User user);
	public User removeUser(User user);
	public User validateUser(User user);
	
}
