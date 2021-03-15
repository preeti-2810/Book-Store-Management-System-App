package com.book.store.management.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Customer;
import com.book.store.management.app.entities.Review;
import com.book.store.management.app.exceptions.ReviewAlreadyExistException;
import com.book.store.management.app.exceptions.ReviewNotFoundException;
import com.book.store.management.app.repo.IBookRepository;
import com.book.store.management.app.repo.IReviewRepository;
import com.book.store.management.app.serviceInterface.IReviewService;
import com.book.store.management.app.exceptions.BookNotFoundException;


@Service
public class ReviewService implements IReviewService{

	@Autowired
	IReviewRepository reviewRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	IBookRepository bookRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Override
	public List<Review> listAllReviews() {
		
		List<Review> myList = reviewRepository.findAll();
		
		if(myList == null)
			throw new ReviewNotFoundException("There is no review in the repository");
		else
			return myList;
	}

	@Override
	@Transactional
	public Review addReview(Review review) {
		
		// Review rev = reviewRepository.findById(review.getReviewId());
		
		Customer c  = customerService.viewCustomer(review.getCustomer());
		
		Book b = bookService.viewBook(review.getBook());
		
		review.setBook(b);
		review.setCustomer(c);
		
		System.out.println(b);
		
		Review foundReview = reviewRepository.findByCustomerAndBook(c,b);
		
		if(foundReview==null)
			return reviewRepository.save(review);
		
		else
			throw new ReviewAlreadyExistException("This review is already exist in the repository");
		
		
	}

	@Override
	@Transactional
	public Review updateReview(Review review) {
		
//		Review rev = reviewRepository.findById(review.getReviewId());
//		
//		if(rev==null)
//			throw new ReviewNotFoundException("There is no review in the repository");
//		
//		else {
//			
//			rev.setComment(review.getComment());
//		}
		
		return reviewRepository.save(review);
	}

	@Override
	public Review deleteReview(Review review) {
		
		Review rev = reviewRepository.findById(review.getReviewId());
		
		if(rev==null)
			throw new ReviewNotFoundException("There is no review in the repository");
		
		else
			reviewRepository.delete(rev);
		
		return rev;
	}

	@Override
	public Review viewReview(Review review) {
	
		Review rev = reviewRepository.findById(review.getReviewId());
		
		if(rev==null)
			throw new ReviewNotFoundException("There is no review in the repository");
		
		else
			return rev;
	}

	@Override
	public List<Review> listAllReviewsByBook(Book book) {
		
		Book b = bookService.viewBook(book);
		
		List<Review> myList = reviewRepository.findByBook(b);
		if(myList == null)
			throw new ReviewNotFoundException("There is no review in the repository");
		
		return myList;
	}

	@Override
	public List<Review> listAllReviewByCustomer(Customer customer) {
		
		Customer cs = customerService.viewCustomer(customer);
		
		List<Review> myList = reviewRepository.findByCustomer(cs);
		if(myList == null)
			throw new ReviewNotFoundException("There is no review in the repository");
		
		return myList;
	}

	@Override
	public List<Book> listMostFavoredBooks() {
		List<Book> books = bookRepository.listMostFavoredBooks();
		
		if(books == null) {
			
			throw new BookNotFoundException("There is no book in the repository");
		}
		return books;
	}
	
	public void deleteReviewOfCustomer(Customer c)
	{
		reviewRepository.deleteAll(this.listAllReviewByCustomer(c));
	}

}