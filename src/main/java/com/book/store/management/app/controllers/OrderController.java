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
import com.book.store.management.app.entities.OrderDetails;
import com.book.store.management.app.exceptions.OrderNotFoundException;
import com.book.store.management.app.repo.IOrderRepository;
import com.book.store.management.app.services.BookService;
import com.book.store.management.app.services.CustomerService;
import com.book.store.management.app.services.OrderService;

@RestController
public class OrderController {
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<OrderDetails> listAllOrders() {
		log.info("Listing all orders");
		return orderService.listAllOrders();
	}

	@GetMapping("/orders/customer/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<OrderDetails> listOrderByCustomer(@RequestBody Customer c) {
		log.info(" Listing order by Customer");
		return orderService.listOrderByCustomer(c);
	}

	
	public OrderDetails viewOrderForCustomer(OrderDetails od) {
		log.info("Viewing order for customer");
		return orderService.viewOrderForCustomer(od);
	}


	public OrderDetails viewOrderForAdmin(OrderDetails od) {
		log.info("Viewing order for admin");
		return orderService.viewOrderForAdmin(od);
	}

	@DeleteMapping("/orders/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public OrderDetails cancelOrder(@RequestBody OrderDetails od) {
		log.info("Canceling the order");
		return orderService.cancelOrder(od);
	
	}

	@PostMapping("/orders")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrderDetails addOrder(OrderDetails od) {
		log.info("Adding orders");
       return orderService.addOrder(od);
	}

	@PutMapping("/orders/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public OrderDetails updateOrder(OrderDetails od) {
		log.info("Updating orders");
		return orderService.updateOrder(od);
	}

	@GetMapping("/orders/book/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<OrderDetails> viewOrderByBook(Book book) {
		log.info("Viewing order by book");
		return orderService.viewOrderByBook(book);
	}

}
