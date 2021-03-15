package com.book.store.management.app.serviceInterface;

import java.util.List;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Customer;


public interface ICustomerService {

	public Customer createCustomer(Customer c);
	public List<Customer> listCustomers();
	public Customer deleteCustomer(Customer c);
	public Customer viewCustomer(Customer c);
	public Customer updateCustomer(Customer c);
	public List<Customer> listAllCustomersByBook(Book b);
}
