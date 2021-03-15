package com.book.store.management.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Customer;
import com.book.store.management.app.entities.OrderDetails;
import com.book.store.management.app.exceptions.OrderNotFoundException;
import com.book.store.management.app.repo.IOrderRepository;
import com.book.store.management.app.serviceInterface.IOrderService;




@Service
public class OrderService implements IOrderService{
	
	
	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	BookService bookService;
	
	@Override
	public List<OrderDetails> listAllOrders() {
		
		List<OrderDetails> list = orderRepository.findAll();
		return list;
	}

	@Override
	public List<OrderDetails> listOrderByCustomer(Customer cs) {
		
		Customer customer = customerService.viewCustomer(cs);
		
		List<OrderDetails> orderList = orderRepository.findByCustomer(customer);
		return orderList;
	}

	@Override
	public OrderDetails viewOrderForCustomer(OrderDetails od) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails viewOrderForAdmin(OrderDetails od) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails cancelOrder(OrderDetails od) {
		
		OrderDetails orderDetail = orderRepository.findById(od.getId());
		
		if(orderDetail == null)
			throw new OrderNotFoundException("No order found");
		
		else
			orderRepository.delete(orderDetail);
		
		return orderDetail;
	
	}

	@Override
	public OrderDetails addOrder(OrderDetails od) {

//		OrderDetails order = orderRepository.findById(od.getId());
//		
//		if(order == null) {
//		
//			orderRepository.save(od);
//			
//		}
//		
//		else
//			throw new OrderAlreadyExistException("This order already exist");
		
		return orderRepository.save(od);
	}

	@Override
	@Transactional
	public OrderDetails updateOrder(OrderDetails od) {

//		OrderDetails orderDetail = orderRepository.findById(od.getId());
//		
//		if(orderDetail == null)
//			throw new OrderNotFoundException("No order found");
//		else
//			orderDetail.setQuantity(od.getQuantity());
		
		return orderRepository.save(od);
	}

	@Override
	public List<OrderDetails> viewOrderByBook(Book book) {
		
		Book b = bookService.viewBook(book);
		List<OrderDetails> orderList = orderRepository.findByBook(b);
		if(orderList==null)
			throw new OrderNotFoundException("No order found");
		
		return orderList;
	}

	public void deleteOrderOfCustomer(Customer c) {
		
		orderRepository.deleteAll(this.listOrderByCustomer(c));
	}
}
