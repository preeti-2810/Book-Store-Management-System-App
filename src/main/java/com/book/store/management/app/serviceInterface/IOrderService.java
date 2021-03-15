package com.book.store.management.app.serviceInterface;

import java.util.List;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Customer;
import com.book.store.management.app.entities.OrderDetails;


public interface IOrderService {

	public List<OrderDetails> listAllOrders();
	public List<OrderDetails> listOrderByCustomer(Customer cs);
	public OrderDetails viewOrderForCustomer(OrderDetails od);
	public OrderDetails viewOrderForAdmin(OrderDetails od);
	public OrderDetails cancelOrder(OrderDetails od);
	public OrderDetails addOrder(OrderDetails od);
	public OrderDetails updateOrder(OrderDetails od);
	public List<OrderDetails> viewOrderByBook(Book book);
	
	
}
