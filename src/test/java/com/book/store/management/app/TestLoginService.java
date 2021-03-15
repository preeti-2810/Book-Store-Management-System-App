package com.book.store.management.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.book.store.management.app.entities.User;
import com.book.store.management.app.serviceInterface.ILoginService;



@SpringBootTest
@RunWith(SpringRunner.class)
public class TestLoginService {

	@Autowired
	ILoginService loginService;
	

	
	@Test
	public void testAddUser() {
		
		User user = new User();
		user.setEmail("abc@yahoo.com");
		user.setPassword("12345");
		user.setRole("Admin");
	
		loginService.addUser(user);
	}
	
	@Test
	public void testValidateUser() {
		

	}
}
