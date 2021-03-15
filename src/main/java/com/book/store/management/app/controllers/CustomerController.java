package com.book.store.management.app.controllers;

import java.util.List;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Customer;
import com.book.store.management.app.exceptions.CustomerAlreadyExistException;
import com.book.store.management.app.exceptions.CustomerNotFoundException;
import com.book.store.management.app.repo.ICustomerRepository;
import com.book.store.management.app.services.BookService;
import com.book.store.management.app.services.CustomerService;
import com.book.store.management.app.services.OrderService;
import com.book.store.management.app.services.ReviewService;

@RestController
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	CustomerService customerService;

	@PostMapping("/customers")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer c) {
		log.info("Creating customer");
		return customerService.createCustomer(c);
		
	}
	
	@GetMapping("/customers/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Customer> listCustomers(){
		log.info("Listing all customers");
		return customerService.listCustomers();
	}
	
	@DeleteMapping("/customers/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Customer deleteCustomer(@RequestBody Customer c) {
		log.info("Deleting the customer");
		return customerService.deleteCustomer(c);
		}
		
	@GetMapping("/customers/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Customer viewCustomer(@RequestBody Customer c) {
		log.info("Viewing customer");
		return customerService.viewCustomer(c);
		
	}
	
	@PutMapping("/customers/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public Customer updateCustomer(@RequestBody Customer c) {
	log.info("Updating Customer");
		
		return customerService.updateCustomer(c);
	}

	@GetMapping("/customers/book/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Customer> listAllCustomersByBook(@RequestBody Book b) {
		log.info("Listing all customer by Books");
		return customerService.listAllCustomersByBook(b);
	}
}
