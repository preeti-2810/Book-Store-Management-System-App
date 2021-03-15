package com.book.store.management.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Customer;
import com.book.store.management.app.exceptions.BookNotFoundException;
import com.book.store.management.app.exceptions.CustomerAlreadyExistException;
import com.book.store.management.app.exceptions.CustomerNotFoundException;
import com.book.store.management.app.repo.ICustomerRepository;
import com.book.store.management.app.serviceInterface.ICustomerService;



@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepository;
	

	
	@Autowired
	BookService bookService;

	public Customer createCustomer(Customer c) {
		
		Customer customer = customerRepository.findByEmail(c.getEmail());
		
		if(customer == null)
			return customerRepository.save(c);
		else
			throw new CustomerAlreadyExistException("Customer with the email " + c.getEmail() + " already exist");
		
	}
	
	public List<Customer> listCustomers(){
		
		List<Customer> list = customerRepository.findAll();
		if(list.isEmpty())
			throw new CustomerNotFoundException("There is no customer in the repository");
		
		return list;
	}
	
	public Customer deleteCustomer(Customer c) {
		
		Customer customer  = customerRepository.findById(c.getCustomerId());
		
		if(customer == null)
			throw new CustomerNotFoundException("There is no customer in the repository to delete with the id " + c.getCustomerId());
				
		else
			customerRepository.delete(customer);
			
		return customer;
	}
	
	public Customer viewCustomer(Customer c) {
		
		Customer customer = customerRepository.findById(c.getCustomerId());
		
		if(customer == null) 
			throw new CustomerNotFoundException("There is no customer in the repository with the id " + c.getCustomerId());
		
		return customer;
	}
	
//	public Optional<Customer> viewCustomer(int c) {
//		
//		Optional<Customer> customer = customerRepository.findById(c);
//		
//		if(!customer.isPresent()) 
//			throw new CustomerNotFoundException("There is no customer in the repository with the id " + c);
//		
//		return customer;
//	}
	
	@Transactional
	public Customer updateCustomer(Customer c) {
		
		Customer customer = customerRepository.findByEmail(c.getEmail());
		
		if(customer==null) 
			throw new BookNotFoundException("There is no customer in the repository with the email" + c.getEmail());
			
		else
			customer.setMobileNumber(c.getMobileNumber());
			
		
		return c;
	}

	@Override
	public List<Customer> listAllCustomersByBook(Book b) {
		
		Book book = bookService.viewBook(b);
		
		List<Customer> list = customerRepository.listByBook(book);
		
		return list;
	}
	

}
