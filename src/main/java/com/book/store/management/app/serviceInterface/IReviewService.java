package com.book.store.management.app.serviceInterface;

import java.util.List;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Customer;
import com.book.store.management.app.entities.Review;




public interface IReviewService {

	public List<Review> listAllReviews();
	public Review addReview(Review review);
	public Review updateReview(Review review);
	public Review deleteReview(Review review);
	public Review viewReview(Review review);
	public List<Review> listAllReviewsByBook(Book book);
	public List<Review> listAllReviewByCustomer(Customer customer);
	public List<Book> listMostFavoredBooks();
	
}
